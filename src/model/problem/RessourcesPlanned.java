package model.problem;

import java.util.List;

public class RessourcesPlanned implements Comparable<RessourcesPlanned> {

    protected double dReleaseDate;
    protected List<Resource> listResource;

    public RessourcesPlanned(List<Resource> listResource, double dReleaseDate) {
        this.dReleaseDate = dReleaseDate;
        this.listResource = listResource;
    }

    protected double getdReleaseDate() {
        return this.dReleaseDate;
    }

    protected List<Resource> getListResource() {
        return this.listResource;
    }

    @Override
    public int compareTo(RessourcesPlanned ressourcesPlanned) {
        if (ressourcesPlanned.dReleaseDate < this.dReleaseDate) {
            return 1;
        } else if (ressourcesPlanned.dReleaseDate > this.dReleaseDate) {
            return 0;
        } else {
            return 0;
        }
    }
}
