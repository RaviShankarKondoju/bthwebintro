package se.example2.softhouse.Note;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(NoteMapper.class)
public interface NoteDAO {

    @SqlQuery("select * from TEST")
    List<Note> getAll();

    @SqlQuery("select * from TEST where ID = :id")
    Note findById(@Bind("id") int id);

    @SqlUpdate("delete from TEST where ID = :id")
    int deleteById(@Bind("id") int id);

    @SqlUpdate("update TEST set TITLE = :title where ID = :id")
    int update(@BindBean Note note);

    @SqlUpdate("insert into TEST (ID, TITLE, TEXT) values (:id, :title, :text)")
    int insert(@BindBean Note note);
}