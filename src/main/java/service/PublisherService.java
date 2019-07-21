package service;

import model.Publisher;

public interface PublisherService {
    Publisher findByPublisherName(String publisherName);
}
