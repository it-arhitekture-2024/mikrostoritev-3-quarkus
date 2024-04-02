package si.um.feri.demo.rest;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import si.um.feri.demo.dao.GradeRepository;
import si.um.feri.demo.vao.Grade;
import si.um.feri.demo.vao.GradeDTO;
import java.util.List;
import java.util.stream.Collectors;

@Path("/grades")
public class GradeResource {

    private static final Logger LOG = Logger.getLogger(GradeResource.class);

    @Inject
    GradeRepository gradeRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<Void> createGrade(Grade grade) {
        LOG.infof("Shranjevanje ocene: %s", grade);
        return gradeRepository.addGrade(grade);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<GradeDTO>> getAllGrades() {
        return gradeRepository.listAllGrades()
                .onItem().transformToUni(grades -> {
                    List<GradeDTO> dtos = grades.stream()
                            .map(GradeDTO::new)
                            .collect(Collectors.toList());
                    LOG.infof("Pridobivanje ocene: %s", dtos);
                    return Uni.createFrom().item(dtos);
                });
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<Void> updateGrade(@PathParam("id") String id, Grade grade) {
        LOG.infof("Posodabljanje ocene z ID: %s", id);
        return gradeRepository.updateGrade(id, grade);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<Void> deleteGrade(@PathParam("id") String id) {
        LOG.infof("Brisanje ocene z ID: %s", id);
        return gradeRepository.deleteGrade(id);
    }
}
