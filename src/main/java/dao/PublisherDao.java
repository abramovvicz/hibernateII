package dao;

import model.Publisher;

public interface PublisherDao {
    Publisher findByPublisherName(String publisherName);
}
