// 1. Selecionando os elementos do HTML
const inputTelefone = document.getElementById('telefone');
const inputSenha = document.getElementById('senha');
const togglePassword = document.getElementById('togglePassword');
const senhaErro = document.getElementById('senha-erro');
const form = document.getElementById('formCadastro');

togglePassword.addEventListener('click', function () {

    const type = inputSenha.getAttribute('type') === 'password' ? 'text' : 'password';
    inputSenha.setAttribute('type', type);
    
    this.textContent = type === 'password' ? '👁️' : '🙈';
});

// 2. MÁSCARA DE TELEFONE (VERSÃO DESIGNER: FLUXO LIVRE)
inputTelefone.addEventListener('keydown', (e) => {
    if (e.key === 'Backspace') {
        const input = e.target;
        const pos = input.selectionStart;
        let v = input.value;

        // Se o cursor estiver após o ") ", apaga o número dentro do parêntese
        if (pos === 5) { 
            e.preventDefault();
            // Pega os números, tira o último do DDD e reformata
            let numeros = v.replace(/\D/g, "");
            numeros = numeros.slice(0, 1); 
            input.value = numeros.length > 0 ? `(${numeros}) ` : "(  ) ";
            input.setSelectionRange(numeros.length + 1, numeros.length + 1);
        }
        // Se o cursor estiver após o "-", pula o traço e apaga o número
        if (v[pos - 1] === '-') {
            e.preventDefault();
            let numeros = v.replace(/\D/g, "");
            numeros = numeros.slice(0, -1);
            // Aplica a formatação de novo sem o último dígito
            input.value = `(${numeros.substring(0, 2)}) ${numeros.substring(2, 7)}-${numeros.substring(7)}`;
            input.setSelectionRange(pos - 1, pos - 1);
        }
    }
});

inputTelefone.addEventListener('input', (e) => {
    let input = e.target;
    let v = input.value.replace(/\D/g, ""); // Pega só números

    if (v.length === 0) {
        input.value = "(  ) ";
        input.setSelectionRange(1, 1);
        return;
    }

    if (v.length <= 2) {
        input.value = `(${v}) `;
    } else if (v.length <= 7) {
        input.value = `(${v.substring(0, 2)}) ${v.substring(2)}`;
    } else {
        input.value = `(${v.substring(0, 2)}) ${v.substring(2, 7)}-${v.substring(7, 11)}`;
    }
});

// Garante que o usuário sempre comece a digitar no lugar certo
inputTelefone.addEventListener('click', (e) => {
    if (e.target.value === "(  ) ") {
        e.target.setSelectionRange(1, 1);
    }
});

// 3. VALIDAÇÃO DA SENHA AO DIGITAR E AO ENVIAR
function validarSenha(senha) {
    // Expressão regular: 8 caracteres, 1 Maiúscula, 1 Minúscula, 1 Número, 1 Especial
    const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8}$/;
    return regex.test(senha);
}

form.addEventListener('submit', (e) => {
    const senhaValue = inputSenha.value;

    if (!validarSenha(senhaValue)) {
        e.preventDefault(); // Impede o envio do formulário
        senhaErro.textContent = "Preencha a senha corretamente (8 dígitos, A, a, 1, !)";
        inputSenha.style.borderColor = "#ff4d4d";
    } else {
        senhaErro.textContent = "";
        alert("Cadastro enviado com sucesso! Bem-vindo ao Inkflow.");
    }
});