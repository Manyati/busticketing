package za.ca.cput.busticketing.entity.card;


import za.ca.cput.busticketing.entity.user.UserCard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 * CardStatus Entity class
 */

@Entity
public class CardStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    protected CardStatus(){

    }

    private CardStatus(CardStatus.Builder builder) {
        this.name= builder.name;
        this.description = builder.description;
    }

    //remove getters please.

    public static class Builder {
        private Integer id;
        private String name;
        private String description;

        public CardStatus.Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public CardStatus.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public CardStatus.Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public CardStatus.Builder copy(CardStatus cardStatus) {

            return this;
        }

        public CardStatus build() {
            return new CardStatus(this);
        }

    }
}
