package ConcertPack;

import Excepciones.StockInsuficienteException;
import Interfaces.Vendible;

public abstract class Entradas implements Vendible {
        private int stock;
        private double precio;
        private TipoEntrada tipo;

        public Entradas(int stock, TipoEntrada tipo) {
            this.stock = stock;
            this.precio =calcularPrecio();
            this.tipo = tipo;
        }

        public double calcularPrecio()
        {
            double prc = 10000;
            if (this.getTipo() == tipo.VIP)
            {
                prc+=5000;

            }
            return prc;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

    @Override
    public void Venta() {
        try {
            reducirStock();
        } catch (StockInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }
    public void reducirStock() throws StockInsuficienteException {
        if (stock > 0) {
            stock--;
        } else {
            throw new StockInsuficienteException("No hay suficientes entradas disponibles.");
        }
    }


    public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public TipoEntrada getTipo() {
            return tipo;
        }

        public void setTipo(TipoEntrada tipo) {
            this.tipo = tipo;
        }

        @Override
        public String toString() {
            return "ConcertPack.Entradas{" +
                    "stock=" + stock +
                    ", precio=" + precio +
                    ", tipo=" + tipo +
                    '}';
        }
}

