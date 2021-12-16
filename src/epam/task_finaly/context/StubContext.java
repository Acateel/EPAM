package epam.task_finaly.context;

public class StubContext implements Contextable {
    private Object data;

    @Override
    public Object read() {
        return data;
    }

    @Override
    public void write(Object obj) {
        data = obj;
    }
}
