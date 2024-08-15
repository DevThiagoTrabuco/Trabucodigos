package Atividade04;

public class ControleTv {
    private int channel, volume;

    public ControleTv(int canal, int vol){
        this.channel = canal;
        this.volume = vol;
    }

    public int getchannel(){
        return channel;
    }
    public void setchannel(int canal){
        channel = canal;
    }
    public int getvolume(){
        return volume;
    }

    public void aumentarVol(){
        if(volume < 100){
            volume+=5;
        }
    }
    public void abaixarVol(){
        if(volume > 0){
            volume-=5;
        }
    }
}
