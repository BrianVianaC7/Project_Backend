package com.project.modulo4.models.model;

public class PlayerModel {

    private long id;
    private String name;
    private String lastName;
    private String nickName;
    private String gender;
    private String birthDate;
    private int age;
    private int numberJersey;
    private String nation;
    private String league;
    private String clubTeam;
    private String position;
    private int trophies;
    private String image;

    public PlayerModel(long id, String name, String lastName, String nickName, String gender, String birthDate, int age, int numberJersey, String nation, String league, String clubTeam, String position, int trophies, String image) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.nickName = nickName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.age = age;
        this.numberJersey = numberJersey;
        this.nation = nation;
        this.league = league;
        this.clubTeam = clubTeam;
        this.position = position;
        this.trophies = trophies;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberJersey() {
        return numberJersey;
    }

    public void setNumberJersey(int numberJersey) {
        this.numberJersey = numberJersey;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getClubTeam() {
        return clubTeam;
    }

    public void setClubTeam(String clubTeam) {
        this.clubTeam = clubTeam;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTrophies() {
        return trophies;
    }

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
