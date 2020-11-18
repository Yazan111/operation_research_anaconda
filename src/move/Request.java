package move;

public class Request {
    private String mRequestName;
    private String mSquareId;
    private String mLocation;


    public String getRequestName() {
        return mRequestName;
    }

    public void setRequestName(String requestName) {
        mRequestName = requestName;
    }

    public String getSquareId() {
        return mSquareId;
    }

    public void setSquareId(String squareId) {
        mSquareId = squareId;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    @Override
    public String toString() {
        return "Request{" +
                "mRequestName='" + mRequestName + '\'' +
                ", mSquareId='" + mSquareId + '\'' +
                ", mLocation='" + mLocation + '\'' +
                '}';
    }
}
