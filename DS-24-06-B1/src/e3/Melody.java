package e3;

import java.util.ArrayList;
import java.util.Objects;

public class Melody {

    ArrayList<Melody> Melodylist = new ArrayList<>();

    private Notes note;
    private Accidentals accidental;
    private float time;


    enum Notes {
        DO, RE, MI, FA, SOL, LA, SI
    }

    enum Accidentals {
        NATURAL, SHARP, FLAT
    }



    public Melody(Notes note, Accidentals accidental, float time) {
        if (time <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.time = time;
        }
        if (note == null) {
            throw new IllegalArgumentException();
        } else {
            this.note = note;
        }
        if (accidental == null) {
            throw new IllegalArgumentException();
        } else {
            this.accidental = accidental;
        }
    }

    public Melody() {
    }

    public void addNote(Notes note, Accidentals accidental, float time) {
        Melodylist.add(new Melody(note, accidental, time));
    }

    public Notes getNote(int index) {
        if(Melodylist.isEmpty() || index > size()-1){
            throw new IllegalArgumentException();
        }else {
            Melody melodia;
            melodia = Melodylist.get(index);
            return melodia.note;
        }
    }

    public Accidentals getAccidental(int index) {
        if(Melodylist.isEmpty() || index > Melodylist.size()-1){
            throw new IllegalArgumentException();
        }
        Melody melodia;
        melodia = Melodylist.get(index);
        return melodia.accidental;
    }

    public float getTime(int index) {
        if(Melodylist.isEmpty() || index > Melodylist.size()-1){
            throw new IllegalArgumentException();
        }
        else {
            Melody melodia;
            melodia = Melodylist.get(index);
            return melodia.time;
        }
    }


    public float getDuration() {
        float tiempo = 0;
        if(Melodylist.isEmpty()){
            tiempo=0;
        }
        else {
            for (int i = 0; i < Melodylist.size(); i++) {
                Melody Melodia;
                Melodia = Melodylist.get(i);
                tiempo = tiempo + Melodia.time;
            }
        }
        return tiempo;
    }

    public int size() {
        return Melodylist.size();
    }


    public boolean equals(Object o){//DOS MELODIAS SON IGUALES SI DURAN LOS MISMO Y TIENEN LAS MISMA NOTAS O NOTAS EQUIVALENTES
        if(this==o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        ArrayList<Melody> Melodylist2;
        Melodylist2=((Melody) o).Melodylist;
        Melody melody2,melody1;
        int i,j;
        int contador = 0;
        for(i=0,j=0;i < Melodylist.size() && j < Melodylist2.size();i++,j++) {
            melody2 = Melodylist2.get(j);
            melody1 = Melodylist.get(i);
            if (melody1.note == melody2.note && melody1.accidental == melody2.accidental && melody1.time == melody2.time) {
                contador += 1;
            }
            if (melody1.note == Notes.DO && melody1.accidental == Accidentals.SHARP && melody2.note == Notes.RE && melody2.accidental == Accidentals.FLAT && melody1.time == melody2.time) {
                contador += 1;
            }
            if (melody1.note == Notes.RE && melody1.accidental == Accidentals.SHARP && melody2.note == Notes.MI && melody2.accidental == Accidentals.FLAT && melody1.time == melody2.time) {
                contador += 1;
            }
            if (melody1.note == Notes.MI && melody1.accidental == Accidentals.NATURAL && melody2.note == Notes.FA && melody2.accidental == Accidentals.FLAT && melody1.time == melody2.time) {
                contador += 1;
            }
            if (melody1.note == Notes.MI && melody1.accidental == Accidentals.SHARP && melody2.note == Notes.FA && melody2.accidental == Accidentals.NATURAL && melody1.time == melody2.time) {
                contador += 1;
            }
            if (melody1.note == Notes.FA && melody1.accidental == Accidentals.SHARP && melody2.note == Notes.SOL && melody2.accidental == Accidentals.FLAT && melody1.time == melody2.time) {
                contador += 1;
            }
            if (melody1.note == Notes.SOL && melody1.accidental == Accidentals.SHARP && melody2.note == Notes.LA && melody2.accidental == Accidentals.FLAT && melody1.time == melody2.time) {
                contador += 1;
            }
            if (melody1.note == Notes.LA && melody1.accidental == Accidentals.SHARP && melody2.note == Notes.SI && melody2.accidental == Accidentals.FLAT && melody1.time == melody2.time) {
                contador += 1;
            }
            if (melody1.note == Notes.SI && melody1.accidental == Accidentals.NATURAL && melody2.note == Notes.DO && melody2.accidental == Accidentals.FLAT && melody1.time == melody2.time) {
                contador += 1;
            }
            if (melody1.note == Notes.SI && melody1.accidental == Accidentals.SHARP && melody2.note == Notes.DO && melody2.accidental == Accidentals.NATURAL && melody1.time == melody2.time) {
                contador += 1;
            }
            if (melody2.note == Notes.DO && melody2.accidental == Accidentals.SHARP && melody1.note == Notes.RE && melody1.accidental == Accidentals.FLAT && melody1.time == melody2.time) {
                contador += 1;
            }
            if (melody2.note == Notes.RE && melody2.accidental == Accidentals.SHARP && melody1.note == Notes.MI && melody1.accidental == Accidentals.FLAT && melody1.time == melody2.time) {
                contador += 1;
            }
            if (melody2.note == Notes.MI && melody2.accidental == Accidentals.NATURAL && melody1.note == Notes.FA && melody1.accidental == Accidentals.FLAT && melody1.time == melody2.time) {
                contador += 1;
            }
            if (melody2.note == Notes.MI && melody2.accidental == Accidentals.SHARP && melody1.note == Notes.FA && melody1.accidental == Accidentals.NATURAL && melody1.time == melody2.time) {
                contador+=1;
            }
            if (melody2.note == Notes.FA && melody2.accidental == Accidentals.SHARP && melody1.note == Notes.SOL && melody1.accidental == Accidentals.FLAT && melody1.time == melody2.time) {
                contador +=1;
            }
            if (melody2.note == Notes.SOL && melody2.accidental == Accidentals.SHARP && melody1.note == Notes.LA && melody1.accidental == Accidentals.FLAT && melody1.time == melody2.time) {
                contador+=1;
            }
            if (melody2.note == Notes.LA && melody2.accidental == Accidentals.SHARP && melody1.note == Notes.SI && melody1.accidental == Accidentals.FLAT && melody1.time == melody2.time) {
                contador += 1;
            }
            if (melody2.note == Notes.SI && melody2.accidental == Accidentals.NATURAL && melody1.note == Notes.DO && melody1.accidental == Accidentals.FLAT && melody1.time == melody2.time) {
                contador+=1;
            }
            if (melody2.note == Notes.SI && melody2.accidental == Accidentals.SHARP && melody1.note == Notes.DO && melody1.accidental == Accidentals.NATURAL && melody1.time == melody2.time) {
                contador+=1;
            }


        }
        return contador == Melodylist.size() && contador == Melodylist2.size();
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.note);
        hash = 53 * hash + Objects.hashCode(this.time);
        hash = 53 * hash + Objects.hashCode(this.accidental);
        return hash;
    }

    @Override
    public String toString() {
        Melody melodia;
        StringBuilder song = new StringBuilder();
        for (int i = 0; i < Melodylist.size(); i++) {
            melodia = Melodylist.get(i);
            if (melodia.accidental == Accidentals.SHARP) {
                song.append(melodia.note).append("#").append("(").append(melodia.time).append(") ");
            } else if (melodia.accidental == Accidentals.NATURAL) {
                song.append(melodia.note).append("(").append(melodia.time).append(") ");
            } else {
                song.append(melodia.note).append("b").append("(").append(melodia.time).append(") ");
            }
        }
        return song.toString().trim();
    }
}