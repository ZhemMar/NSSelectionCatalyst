package com.example.demo;

import java.util.Objects;

public class Material {

    String pretty_formula;

    double energy;
    double energy_per_atom;
    double volume;
    double formation_energy_per_atom;
    int nsites;
    double e_above_hull;
    double density;    
    double total_magnetization;

    public Material() {
    }

    public Material(String pretty_formula, double energy, double energy_per_atom, double volume, 
    double formation_energy_per_atom, int nsites, double e_above_hull, double density, double total_magnetization) {
        this.pretty_formula = pretty_formula;
        this.energy = energy;
        this.energy_per_atom = energy_per_atom;
        this.volume = volume;
        this.formation_energy_per_atom = formation_energy_per_atom;
        this.nsites = nsites;
        this.e_above_hull = e_above_hull;
        this.density = density;
        this.total_magnetization = total_magnetization;
    }


    public String getPretty_formula() {
        return this.pretty_formula;
    }

    public void setPretty_formula(String pretty_formula) {
        this.pretty_formula = pretty_formula;
    }

    public double getEnergy() {
        return this.energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getEnergy_per_atom() {
        return this.energy_per_atom;
    }

    public void setEnergy_per_atom(double energy_per_atom) {
        this.energy_per_atom = energy_per_atom;
    }

    public double getVolume() {
        return this.volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getFormation_energy_per_atom() {
        return this.formation_energy_per_atom;
    }

    public void setFormation_energy_per_atom(double formation_energy_per_atom) {
        this.formation_energy_per_atom = formation_energy_per_atom;
    }

    public int getNsites() {
        return this.nsites;
    }

    public void setNsites(int nsites) {
        this.nsites = nsites;
    }

    public double getE_above_hull() {
        return this.e_above_hull;
    }

    public void setE_above_hull(double e_above_hull) {
        this.e_above_hull = e_above_hull;
    }

    public double getDensity() {
        return this.density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getTotal_magnetization() {
        return this.total_magnetization;
    }

    public void setTotal_magnetization(double total_magnetization) {
        this.total_magnetization = total_magnetization;
    }

    public Material pretty_formula(String pretty_formula) {
        setPretty_formula(pretty_formula);
        return this;
    }

    public Material energy(double energy) {
        setEnergy(energy);
        return this;
    }

    public Material energy_per_atom(double energy_per_atom) {
        setEnergy_per_atom(energy_per_atom);
        return this;
    }

    public Material volume(double volume) {
        setVolume(volume);
        return this;
    }

    public Material formation_energy_per_atom(double formation_energy_per_atom) {
        setFormation_energy_per_atom(formation_energy_per_atom);
        return this;
    }

    public Material nsites(int nsites) {
        setNsites(nsites);
        return this;
    }

    public Material e_above_hull(double e_above_hull) {
        setE_above_hull(e_above_hull);
        return this;
    }

    public Material density(double density) {
        setDensity(density);
        return this;
    }

    public Material total_magnetization(double total_magnetization) {
        setTotal_magnetization(total_magnetization);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Material)) {
            return false;
        }
        Material material = (Material) o;
        return Objects.equals(pretty_formula, material.pretty_formula) && energy == material.energy && energy_per_atom == material.energy_per_atom && volume == material.volume && formation_energy_per_atom == material.formation_energy_per_atom && nsites == material.nsites && e_above_hull == material.e_above_hull && density == material.density && total_magnetization == material.total_magnetization;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pretty_formula, energy, energy_per_atom, volume, formation_energy_per_atom, nsites, e_above_hull, density, total_magnetization);
    }

    @Override
    public String toString() {
        return "{" +
            " pretty_formula='" + getPretty_formula() + "'" +
            ", energy='" + getEnergy() + "'" +
            ", energy_per_atom='" + getEnergy_per_atom() + "'" +
            ", volume='" + getVolume() + "'" +
            ", formation_energy_per_atom='" + getFormation_energy_per_atom() + "'" +
            ", nsites='" + getNsites() + "'" +
            ", e_above_hull='" + getE_above_hull() + "'" +
            ", density='" + getDensity() + "'" +
            ", total_magnetization='" + getTotal_magnetization() + "'" +
            "}";
    }
    

}
