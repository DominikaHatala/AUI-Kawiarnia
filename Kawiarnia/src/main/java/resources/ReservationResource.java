package resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import entities.Reservation;
import servlet.ReservationContext;



@Path("/reservations")
public class ReservationResource {

    public static final String RESERVATION_CONTEXT = "reservationContext";


    @Context
    ServletContext context;

    @Context
    HttpServletRequest request;

    @Context
    HttpServletResponse response;

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reservation> listReservations() {
        return getReservationContext().findAllReservations();
    }


    @GET
    @Path("find")
    @Produces(MediaType.APPLICATION_JSON)
    public Reservation findReservation(@DefaultValue("-1") @QueryParam("numer") Integer reservationNumber) {
        return getReservationContext().findReservation(reservationNumber);
    }

    @POST
    @Path("save")
    public void saveReservation(@FormParam("numer") Integer numer, @FormParam("data") String data, @FormParam("godzina") String godzina) throws IOException {
        Reservation reservation = new Reservation(numer, data, godzina);
        getReservationContext().saveReservation(reservation);
        response.sendRedirect("../../rezerwacje.html");
    }

    private ReservationContext getReservationContext() {
        ReservationContext reservationContext = (ReservationContext) context.getAttribute(RESERVATION_CONTEXT);
        if (reservationContext == null) {
            reservationContext = new ReservationContext();
            context.setAttribute(RESERVATION_CONTEXT, reservationContext);
        }
        return reservationContext;
    }

}
