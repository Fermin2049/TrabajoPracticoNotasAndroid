# Trabajo Practico Notas Android

Este es un proyecto de una aplicación Android para la gestión de notas, desarrollado como parte de un trabajo práctico.

## Características

- **Gestión de Notas:** Crear, visualizar, y editar notas con fechas de creación y finalización.
- **Interfaz de Usuario Dinámica:** Implementación de Fragments para manejar diferentes vistas como listas de notas, notas a punto de vencer, y más.
- **Navegación Intuitiva:** Uso de `BottomNavigationView` y `NavController` para facilitar la navegación entre diferentes secciones de la aplicación.

## Tecnologías Utilizadas

- **Lenguaje:** Java
- **Framework:** Android SDK
- **Arquitectura:** MVVM (Model-View-ViewModel)
- **Dependencias:**
  - Material Components
  - Lifecycle ViewModel y LiveData
  - Navigation Component

## Estructura del Proyecto

- `app/src/main/java/com/fermin2049/trabajopractico3/`:
  - **MainActivity.java**: Actividad principal que configura la navegación y maneja las interacciones generales de la aplicación.
  - **IntroActivity.java**: Actividad de introducción que actúa como pantalla de bienvenida.
  - **Model/Note.java**: Clase de modelo que representa una nota.
  - **Model/NoteAdapter.java**: Adaptador de RecyclerView para mostrar notas en listas.
  - **ui/**: Contiene los fragmentos y sus respectivos ViewModels para las diferentes vistas de la aplicación (Lista, Home, etc.).

- `app/src/main/res/`: Recursos de la aplicación, como layouts XML, strings, y drawables.

## Instalación

1. Clonar el repositorio:

    ```bash
    git clone https://github.com/Fermin2049/TrabajoPracticoNotasAndroid.git
    ```

2. Abrir el proyecto en **Android Studio**.

3. Sincronizar las dependencias de Gradle.

## Ejecución

- Asegúrate de tener un emulador o un dispositivo físico conectado.
- Ejecuta el proyecto desde Android Studio utilizando el botón "Run".

## Contribución

Si deseas contribuir al proyecto, puedes seguir los siguientes pasos:

1. Haz un fork del repositorio.
2. Crea una rama con tu nueva característica (`git checkout -b feature/nuevaCaracteristica`).
3. Realiza tus cambios y haz commit (`git commit -m 'Agregada nueva característica'`).
4. Empuja la rama (`git push origin feature/nuevaCaracteristica`).
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.
