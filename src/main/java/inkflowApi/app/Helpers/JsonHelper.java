package inkflowApi.app.Helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class JsonHelper {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> void criarJson(T dados, String path) {
        try {
            File file = new File(path);
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            } // cria a pasta se não existir
            mapper.writeValue(file, dados);
        }  catch(IOException e){
            throw new RuntimeException("Erro ao salvar JSON", e);
        }
    }
    public static <T> List<T> carregarJson(String path, TypeReference<List<T>> typeReference) {
        try {
            File file = new File(path);
            if (!file.exists()) return new ArrayList<>();

            return mapper.readValue(file, typeReference);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    public static <T> List<T> atualizarJson(
            String path,
            T dadoAtualizado,
            Function<T, Object> getId,
            TypeReference<List<T>> typeReference)
    {
        // 1. Carrega a lista atual
        List<T> lista = carregarJson(path, typeReference);
        Object idNovo = getId.apply(dadoAtualizado);

        // 2. Procura e substitui
        for (int i = 0; i < lista.size(); i++) {
            Object idExistente = getId.apply(lista.get(i));
            if (idExistente.equals(idNovo)) {
                lista.set(i, dadoAtualizado);
                break;
            }
        }
        // 3. Salva a lista de volta
        criarJson(lista, path);
        return lista;
    }
    public static <T> List<T> removerJson(
            String path,
            Object id, Function<T, Object> getId,
            TypeReference<List<T>> typeReference)
    {
        List<T> lista = carregarJson(path, typeReference);

        // Remove e já temos a lista atualizada em memória
        lista.removeIf(item -> getId.apply(item).equals(id));

        criarJson(lista, path); // Salva no arquivo
        return lista; // Retorna a lista sem o item deletado
    }
}
