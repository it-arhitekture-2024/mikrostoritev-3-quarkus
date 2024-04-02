package si.um.feri.demo.vao;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Grade extends ReactivePanacheMongoEntity {
    public String studentId;
    public String professorId;
    public String subjectId;
    public int gradeValue;
    public String description;
}