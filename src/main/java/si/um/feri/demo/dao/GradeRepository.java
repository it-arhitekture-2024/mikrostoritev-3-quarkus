package si.um.feri.demo.dao;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.jboss.logging.Logger;
import si.um.feri.demo.rest.GradeResource;
import si.um.feri.demo.vao.Grade;
import java.util.List;

@ApplicationScoped
public class GradeRepository implements ReactivePanacheMongoRepository<Grade> {
    private static final Logger LOG = Logger.getLogger(GradeResource.class);

    public Uni<Void> addGrade(Grade grade) {
        LOG.infof("Adding grade: %s", grade);
        return persist(grade).replaceWithVoid();
    }

    public Uni<List<Grade>> listAllGrades() {
        LOG.info("Listing all grades");
        return findAll().list();
    }

    public Uni<Void> updateGrade(String id, Grade updatedGrade) {
        ObjectId objectId = new ObjectId(id);
        LOG.infof("Updating grade with ID %s: %s", id, updatedGrade);
        return findById(objectId)
                .onItem().ifNotNull().transformToUni(existingGrade -> {
                    existingGrade.studentId = updatedGrade.studentId;
                    existingGrade.professorId = updatedGrade.professorId;
                    existingGrade.subjectId = updatedGrade.subjectId;
                    existingGrade.gradeValue = updatedGrade.gradeValue;
                    existingGrade.description = updatedGrade.description;
                    return existingGrade.update().replaceWithVoid();
                });
    }

    public Uni<Void> deleteGrade(String id) {
        ObjectId objectId = new ObjectId(id);
        LOG.infof("Deleting grade with ID %s", id);
        return deleteById(objectId).replaceWithVoid();
    }
}
