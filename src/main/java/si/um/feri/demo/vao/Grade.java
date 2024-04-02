package si.um.feri.demo.vao;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

public class Grade extends ReactivePanacheMongoEntity {
    public String studentId;
    public String professorId;
    public String subjectId;
    public int gradeValue;
    public String description;
}