package si.um.feri.demo.dao;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import si.um.feri.demo.vao.Grade;

import java.util.List;

@ApplicationScoped
public class GradeRepository implements ReactivePanacheMongoRepository<Grade> {

    public Uni<Void> addGrade(Grade grade) {
        return persist(grade).replaceWithVoid();
    }

    public Uni<List<Grade>> listAllGrades() {
        return findAll().list();
    }
}
