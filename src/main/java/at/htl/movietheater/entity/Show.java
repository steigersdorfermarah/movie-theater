package at.htl.movietheater.entity;

import javax.persistence.*;

@Entity(name = "MT_SHOW")
@SequenceGenerator(name = "showSeq", initialValue = 1000)
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "showSeq")
    @Column(name = "SH_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SH_MO_ID")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "SH_TH_ID")
    private Theater theater;

    @OneToOne
    @JoinColumn(name = "SH_PREV_SHOW_ID")
    private Show prevShow;

    @OneToOne
    @JoinColumn(name = "SH_NEXT_SHOW_ID")
    private Show nextShow;

    public Show() {
    }

    public Show(Movie movie, Theater theater, Show prevShow, Show nextShow) {
        this.movie = movie;
        this.theater = theater;
        this.prevShow = prevShow;
        this.nextShow = nextShow;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Show getPrevShow() {
        return prevShow;
    }

    public void setPrevShow(Show prevShow) {
        this.prevShow = prevShow;
    }

    public Show getNextShow() {
        return nextShow;
    }

    public void setNextShow(Show nextShow) {
        this.nextShow = nextShow;
    }

    @Override
    public String toString() {
        return String.format("%s shown in %s", movie.getTitle(), theater.getName());
    }
}
