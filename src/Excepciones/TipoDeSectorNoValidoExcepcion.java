package Excepciones;

public class TipoDeSectorNoValidoExcepcion extends RuntimeException {

    public TipoDeSectorNoValidoExcepcion(){}

    public TipoDeSectorNoValidoExcepcion(String msg)
    {
        super(msg);
    }

    public TipoDeSectorNoValidoExcepcion(String message, Throwable cause)
    {
        super(message, cause);
    }

    public TipoDeSectorNoValidoExcepcion(Throwable cause) {
        super(cause);
    }


}