package org.gestao_reserva.entity;

import java.util.Date;

public interface Reservavel {
    void reservar(int num, Date dataCheckin, Date dataCheckout);
    void cancelarReserva(int idReserva);
}
