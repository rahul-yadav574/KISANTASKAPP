package in.evolve.kisantaskapp.Models;

public class Task {

    private String name;
    private String completed;
    private int _id;

    public Task(String name, String completed,int _id) {
        this.name = name;
        this.completed = completed;
        this._id  = _id;
    }

    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompleted() {
        return this.completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }
}
