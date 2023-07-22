package programacionIII.app;


import programacionIII.app.presentation.GamePresentationImpl;

public class App
{
    public static void main( String[] args ){
        GamePresentationImpl gamePresentacion = new GamePresentationImpl();
        gamePresentacion.Menu();
    }
}

