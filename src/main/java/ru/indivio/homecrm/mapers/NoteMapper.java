package ru.indivio.homecrm.mapers;

import ru.indivio.homecrm.entities.Note;
import ru.indivio.homecrm.services.NoteNotFoundException;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class NoteMapper {

    public NoteMapper(){

    }

    public Note getNote(int key) throws Exception{
        Note note = IdentityNoteMap.getNote(key);
        if(note!=null)
        {
            return note;
        }
        else {
            Note noteFromDb = findById(key);
            IdentityNoteMap.addNote(noteFromDb);
            return noteFromDb;
        }
    }

    public void deleteNote(int key) throws Exception{
        Note note = IdentityNoteMap.getNote(key);
        if(note!=null)
        {
            deleteById(key);
            IdentityNoteMap.deleteNote(key);

        }
        else {
            System.out.println("Запись Note с key=" + key + " в Map не существует" );

        }
    }
    public void insertNote(String title, String text) throws Exception{


            insert(title,text);
            Note insertedNote = getNoteByTitleAndText(title,text);
            IdentityNoteMap.addNote(insertedNote);


    }

    private Note getNoteByTitleAndText(String title,String text) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/homecrm", "root", "123456"))
        {
            PreparedStatement statement = connection.prepareStatement("SELECT id, title,text FROM note WHERE title = ? AND text = ?");
            statement.setString(1, title);
            statement.setString(1, text);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int noteId = resultSet.getInt(1);
                String noteTitle = resultSet.getString(2);
                String noteText = resultSet.getString(3);
                resultSet.close();
                connection.close();
                statement.close();
                Note note = new Note(noteId, noteTitle, noteText);
                return note;
            }
            throw new NoteNotFoundException("Запись Note с title =".concat(title).concat(" не найден"));
        }
    }

    private static Note findById(int key) throws ClassNotFoundException, NoSuchMethodException, SQLException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/homecrm", "root", "123456"))
        {
            PreparedStatement statement = connection.prepareStatement("SELECT id, title,text FROM note WHERE id = ?");
            statement.setInt(1, key);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int noteId = resultSet.getInt(1);
                String noteTitle = resultSet.getString(2);
                String noteText = resultSet.getString(3);
                resultSet.close();
                connection.close();
                statement.close();
                Note note = new Note(noteId, noteTitle, noteText);
                return note;
            }
            throw new NoteNotFoundException("Запись Note с ID =".concat(String.valueOf(key)).concat("не найден"));
        }

    }
    private void deleteById(int key) throws NoteNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/homecrm", "root", "123456")) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM note WHERE id = ?");
            statement.setInt(1, key);
            ResultSet resultSet = statement.executeQuery();
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException exception) {
            throw new NoteNotFoundException("Ошибка удаления Записи Note с <ID ="
                    .concat(String.valueOf(key))
                    .concat("> из базы")
                    .concat(String.valueOf(exception)));
        }
    }

    private void update(Note note) throws NoteNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/homecrm", "root", "123456")) {
            PreparedStatement statement = connection.prepareStatement("UPDATE note SET title =?, text=? WHERE id = ?");
            statement.setString(1, note.getTitle());
            statement.setString(2, note.getText());
            statement.setInt(3, note.getId());
            ResultSet resultSet = statement.executeQuery();
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException exception) {
            throw new NoteNotFoundException("Ошибка обновления Записи Note с <ID ="
                    .concat(String.valueOf(note.getId()))
                    .concat("> в базе")
                    .concat(String.valueOf(exception)));
        }
    }

    private void insert(String title, String text) throws NoteNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/homecrm", "root", "123456")) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO note (title, text) VALUES (?, ?)");
            statement.setString(1, title);
            statement.setString(2, text);
            ResultSet resultSet = statement.executeQuery();
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException exception) {
            throw new NoteNotFoundException("Ошибка добавления Записи Note с заголовком <"
                    .concat(title)
                    .concat("> в базу")
                    .concat(String.valueOf(exception)));
        }
    }
}





