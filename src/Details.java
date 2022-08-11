import java.io.*;

public class Details {
    public static int[] readDetails(Player player) {
        int [] login = {1, 1, 0, 0};

        try {
            FileInputStream f1 = new FileInputStream("/D://MIT//sem-5//Java//Game//db.txt/");
            ObjectInputStream is = new ObjectInputStream(f1);

            Player[] players = (Player[]) is.readObject();

            for(Player p: players) {
                if(p.username.equals(player.username)){
                    if(p.password.equals(player.password)) {
                        login[2] = p.win;
                        login[3] = p.loss;
                        return login;
                    } else {
                        login[1] = 0;
                        return login;
                    }
                }
            }
            login[0] = 0;
        }  catch(Exception e) {
            login[0] = 0;
            return login;
        }

        return login;
    }

    public static boolean writeDetails(Player player) {
        try {
            FileInputStream f1 = new FileInputStream("/D://MIT//sem-5//Java//Game//db.txt/");
            ObjectInputStream is = new ObjectInputStream(f1);

            Player [] players = (Player []) is.readObject();
            for(Player p: players) {
                if(p.username.equals(player.username)) {
                    return false;
                }
            }

            Player [] newPlayers = new Player[players.length + 1];
            int i=0;
            for(;i<players.length;i++) {
                newPlayers[i] = players[i];
            }
            newPlayers[i] = player;

            FileOutputStream fo = new FileOutputStream("/D://MIT//sem-5//Java//Game//db.txt/");
            ObjectOutputStream os = new ObjectOutputStream(fo);
            os.writeObject(newPlayers);

            return true;

        } catch(EOFException e) {
            Player [] players = new Player[1];
            players[0] = player;

            try {
                FileOutputStream fo = new FileOutputStream("/D://MIT//sem-5//Java//Game//db.txt/");
                ObjectOutputStream os = new ObjectOutputStream(fo);
                os.writeObject(players);

                return true;
            } catch(Exception err) {
                return false;
            }

        } catch(Exception e) {
            System.out.println(e);
            return false;
        }

    }
    public static void updateScore(String name,int win, int loss){
        try{
            FileInputStream file = new FileInputStream("/D://MIT//sem-5//Java//Game//db.txt/");
            ObjectInputStream is = new ObjectInputStream(file);
            Player[] players = (Player[]) is.readObject();

            for(int i=0;i<players.length;i++){
                if(players[i].username.equals(name)){
                    players[i].win=win;
                    players[i].loss=loss;
                }
            }
            FileOutputStream fo = new FileOutputStream("/D://MIT//sem-5//Java//Game//db.txt/");
            ObjectOutputStream os = new ObjectOutputStream(fo);
            os.writeObject(players);

        }catch (Exception e){
            System.out.println(e);
        }
    }

}