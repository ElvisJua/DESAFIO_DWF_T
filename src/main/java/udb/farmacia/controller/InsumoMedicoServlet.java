package udb.farmacia.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import udb.farmacia.model.InsumoMedico;
import udb.farmacia.service.InsumoMedicoService;

import java.sql.SQLException;
import java.util.List;

@Path("/insumos")
public class InsumoMedicoServlet {
    private InsumoMedicoService service = new InsumoMedicoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllInsumos() {
        try {
            List<InsumoMedico> insumos = service.getAll();
            return Response.ok(insumos).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addInsumo(InsumoMedico insumo) {
        try {
            service.addInsumoMedico(insumo);
            return Response.status(Response.Status.CREATED).entity(insumo).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateInsumo(@PathParam("id") int id, InsumoMedico insumo) {
        try {
            insumo.setId(id);
            service.updateInsumoMedico(insumo);
            return Response.ok(insumo).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteInsumo(@PathParam("id") int id) {
        try {
            service.deleteInsumoMedico(id);
            return Response.noContent().build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}