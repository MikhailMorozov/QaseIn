package api.models;

import lombok.Data;

import java.util.ArrayList;
@Data
public class Result {

    private int total;
    private int filtered;
    private int count;
    private ArrayList<Entities> entities;

}
