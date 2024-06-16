package Excepciones;

public class CapacidadExcedidaExcepcion extends RuntimeException {

    public CapacidadExcedidaExcepcion(){}

    public CapacidadExcedidaExcepcion(String msg)
    {
        super(msg);
    }

    public CapacidadExcedidaExcepcion(String message, Throwable cause)
    {
        super(message, cause);
    }

    public CapacidadExcedidaExcepcion(Throwable cause) {
        super(cause);
    }
}
