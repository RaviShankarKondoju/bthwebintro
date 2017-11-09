package se.example2.softhouse.Note;


import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/note")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class NoteResource1 {

    NoteDAO noteDAO;

    public NoteResource1(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    @GET
    public List<Note> getAll(){
        return noteDAO.getAll();
    }

    @GET
    @Path("/{id}")
    public Note get(@PathParam("id") Integer id){
        return noteDAO.findById(id);
    }

    @POST
    public Note add(@Valid Note note) {
        noteDAO.insert(note);

        return note;
    }

    @PUT
    @Path("/{id}")
    public Note update(@PathParam("id") Long id, @Valid Note note) {
        Note updateNote = new Note(id, note.getTitle(), note.getText());

        noteDAO.update(updateNote);

        return updateNote;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        noteDAO.deleteById(id);
    }
}