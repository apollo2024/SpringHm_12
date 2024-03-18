package ru.java.SpringPatterns.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "task_name")
    private String task_name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "status", nullable = false)
    private TaskStatus status;
    @Column(name = "createdDate")
    private LocalDateTime createdDate;

    private Task(Builder builder) {
        this.id = builder.id;
        this.task_name = builder.task_name;
        this.description = builder.description;
        this.status = builder.status;
        this.createdDate = builder.createdDate;
    }

    public static class Builder {
        private Long id;
        private String task_name;
        private String description;
        private TaskStatus status;
        private LocalDateTime createdDate;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withTaskName(String task_name) {
            this.task_name = task_name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withStatus(TaskStatus status) {
            this.status = status;
            return this;
        }

        public Builder withCreatedDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }
}