package si.um.feri.demo.vao;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import org.bson.types.ObjectId;

public class Grade extends ReactivePanacheMongoEntity {
    public ObjectId id;
    public String studentId;
    public String professorId;
    public String subjectId;
    public int gradeValue;
    public String description;
}