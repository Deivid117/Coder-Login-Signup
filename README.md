# Coder Login Signup

## Description

El siguiente repositorio fue creado como prueba técnica realizando la UI de las pantallas de Login y Signup con lenguaje Kotlin y Jetpack Compose.
El desarrollo de la interfaz contempla validaciones, navegación entre pantallas y tema claro/oscuro, así como también mensajes emergentes dependiendo la interacción del usuario con los componentes. 

### LOGIN

Para la pantalla de login se agregaron validaciones adicionales para el formulario de inicio de sesión.
- Validación de campo vacío: Se validó que el campo de email y de la contraseña no se encuentre vacío.
- Validación de email: Se validó que el email ingresado cuenta con las características principales para ser considera un email válido mediante una expresión regular.

### SIGNUP

Para la pantalla de signup se agregaron validaciones adicionales para el formulario de registro.
- Validación de campo vacío: Se validó que el campo de email, contraseña y número de teléfono no se encuentre vacío.
- Validación de email: Se validó que el email ingresado cuenta con las características principales para ser considera un email válido mediante una expresión regular.
- Validación para número de teléfono: Se validó que únicamente se puedan agregar números y no algún otro caracter especial o letras.
- Validación para contraseña: Se hicieron varias validaciones para escribir una contraseña. Debe contener al menos una letra minúscula, mayúscula, número y caracter especial, así como también para que esta contenga mínimo 10 caracteres.

## Capturas de la aplicación
![login_light](https://github.com/user-attachments/assets/8e0588a2-f5a3-4519-b240-374a9882ce8d)
![signup_light](https://github.com/user-attachments/assets/6dafa1a5-3554-42bd-ba13-d570c3ffe4e9)
![login_dark](https://github.com/user-attachments/assets/dce39e1a-c5db-41c9-83a9-e5b28f731da3)
![signup_dark](https://github.com/user-attachments/assets/bf4adc54-fda5-439e-a5f8-40bb734a089a)

## Video de demostración
https://drive.google.com/file/d/1B0nB34ZLjTtg4bCljVIjKBQNc7iWMSqm/view?usp=sharing
