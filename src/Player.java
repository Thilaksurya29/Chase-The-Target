import java.io.Serializable;

public class Player  implements Serializable {
    public String username, password;
    public int win,loss;

    Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.win = 0;
        this.loss = 0;
    }
}