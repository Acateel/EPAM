package epam.advanced.practice5.task10;

public class Request {
    private RequestType type;
    private String shareName;
    private int shareCount;
    private int sharePrice;
    private Broker broker;

    public Request(RequestType type, String shareName, int shareCount, int sharePrice, Broker broker) {
        this.type = type;
        this.shareName = shareName;
        this.shareCount = shareCount;
        this.sharePrice = sharePrice;
        this.broker = broker;
        this.broker.setRequest(this);
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(int sharePrice) {
        this.sharePrice = sharePrice;
    }

    public RequestType getType() {
        return type;
    }

    public String getShareName() {
        return shareName;
    }

    public Broker getBroker() {
        return broker;
    }

    @Override
    public String toString() {
        return "Request{" +
                "type=" + type +
                ", shareName='" + shareName + '\'' +
                ", shareCount=" + shareCount +
                ", sharePrice=" + sharePrice +
                ", broker=" + broker.getBrokerId() +
                '}';
    }
}
