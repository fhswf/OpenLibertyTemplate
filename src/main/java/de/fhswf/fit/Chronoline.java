package de.fhswf.fit;

import java.util.List;
import java.util.ArrayList;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("chronoline")
@SessionScoped
public class Chronoline implements java.io.Serializable {
    // getter&setter for events
    public static class Event {
        String status;
        String date;
        String icon;
        String color;
        String image;

        public Event(String status, String date, String icon, String color) {
            this.status = status;
            this.date = date;
            this.icon = icon;
            this.color = color;
        }

        public Event(String status, String date, String icon, String color, String image) {
            this.status = status;
            this.date = date;
            this.icon = icon;
            this.color = color;
            this.image = image;
        }

        // getters & setters
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

    }

    private List<Event> events;
    private List<String> events2;

    public Chronoline() {
        events = new ArrayList<>();
        events.add(new Event("Ordered", "15/10/2021 10:30", "pi pi-shopping-cart", "#9C27B0",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/DualShock_4.jpg/678px-DualShock_4.jpg"));
        events.add(new Event("Processing", "15/10/2021 14:00", "pi pi-cog", "#673AB7"));
        events.add(new Event("Shipped", "15/10/2021 16:15", "pi pi-shopping-cart", "#FF9800"));
        events.add(new Event("Delivered", "16/10/2021 10:00", "pi pi-check", "#607D8B"));
        events2 = new ArrayList<>();
        events2.add("2020");
        events2.add("2021");
        events2.add("2022");
        events2.add("2023");
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<String> getEvents2() {
        return events2;
    }

    public void setEvents2(List<String> events2) {
        this.events2 = events2;
    }
}