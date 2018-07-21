package myProject;

public class Player implements IPlayer {
    private String name;
    private String nickname;
    private double credit;
    private IHand hand;

    public Player (String name, String nickname, double credit){
        this.name = name;
        this.nickname = nickname;
        this.credit = credit;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setHand(IHand hand) {
        this.hand = hand;
    }

    @Override
    public IHand getHand() {
        return this.hand;
    }




}
