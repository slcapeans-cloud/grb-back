package com.example.grb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "grb")
public class Grb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGrb;

    @Column(name = "grb_name", nullable = false, unique = true, length = 64)
    private String grbName;

    @Lob
    @Column(name = "grb_text", columnDefinition = "TEXT", nullable = false)
    private String grbText;

    @Column(name = "grb_fov", columnDefinition = "BYTEA")
    private byte[] grbFov;

    @Column(name = "grb_gw", columnDefinition = "BYTEA")
    private byte[] grbGw;

    @Column(name = "grb_plot", columnDefinition = "BYTEA")
    private byte[] grbPlot;



    public Integer getIdGrb() {
        return idGrb;
    }

    public void setIdGrb(Integer idGrb) {
        this.idGrb = idGrb;
    }

    public String getGrbName() {
        return grbName;
    }

    public void setGrbName(String grbName) {
        this.grbName = grbName;
    }

    public String getGrbText() {
        return grbText;
    }

    public void setGrbText(String grbText) {
        this.grbText = grbText;
    }

    public byte[] getGrbFov() {
        return grbFov;
    }

    public void setGrbFov(byte[] grbFov) {
        this.grbFov = grbFov;
    }

    public byte[] getGrbGw() {
        return grbGw;
    }

    public void setGrbGw(byte[] grbGw) {
        this.grbGw = grbGw;
    }

    public byte[] getGrbPlot() {
        return grbPlot;
    }

    public void setGrbPlot(byte[] grbPlot) {
        this.grbPlot = grbPlot;
    }
}
