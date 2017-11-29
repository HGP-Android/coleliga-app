package com.hgp_android.coleliga.partidos;

import com.hgp_android.coleliga.lugares.Place;
import com.hgp_android.coleliga.player.Player;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Partido {

    private String nicknamePartido;
    private Date fecha;
    private String teamA, teamB;
    private ArrayList<Player> players = new ArrayList<Player>();
    private Place place;
    private int maxPlayers;


    public Partido(String nicknamePartido, Date fecha, int maxPlayers) {
        this.nicknamePartido = nicknamePartido;
        this.fecha = fecha;
        this.maxPlayers = maxPlayers;
    }

    public String getNicknamePartido() {
        return nicknamePartido;
    }

    public void setNicknamePartido(String nicknamePartido) {
        this.nicknamePartido = nicknamePartido;
    }

    public String getFecha() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String ffecha = df.format(fecha);
        return ffecha;
    }

    public void setFecha(Date date) {
        this.fecha = date;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }
}
