package ru.akkulov.service;


import lombok.Data;
import ru.akkulov.dao.FeedbackDAO;
import ru.akkulov.model.Feedback;

import java.util.List;

@Data
public class FeedbackService {
    private FeedbackDAO feedbackDAO;

    public FeedbackService() {
        feedbackDAO = new FeedbackDAO();
    }

    public void create(Feedback feedback) {
        feedbackDAO.create(feedback);
    }

    public List<Feedback> getAll() {
        return feedbackDAO.readAll();
    }

    public Feedback getById(int id) {
        return feedbackDAO.getById(id);
    }

    public void updateOne(Feedback feedback, int id) {
        feedbackDAO.updateOne(feedback, id);
    }

    public void deleteOne(int id) {
        feedbackDAO.deleteOne(id);
    }
}
