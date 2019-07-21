package service;

import dao.PublisherDao;
import model.Publisher;

public class PublisherServiceImp implements PublisherService {

    public PublisherDao publisherDao;

    public PublisherServiceImp(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @Override
    public Publisher findByPublisherName(String publisherName) {
        return publisherDao.findByPublisherName(publisherName);
    }
}
