package si.um.feri.demo.rest;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import si.um.feri.demo.dao.GradeRepository;
import si.um.feri.demo.vao.Grade;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import si.um.feri.demo.vao.GradeDTO;


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


}