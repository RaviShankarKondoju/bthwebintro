package se.example2.softhouse.Note;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoteMapper implements ResultSetMapper<Note> {
    public Note map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Note(resultSet.getLong("ID"), resultSet.getString("TITLE"), resultSet.getString("TEXT"));
    }

}