# frozen_string_literal: true
require_relative 'limited_train_ticket_counter'
require_relative 'rejected_ticket'

class RegisteredLimitedTrainTicketCounter < LimitedTrainTicketCounter
  def initialize(max_sales, station)
    super(max_sales, station)
    @rejected = Array.new
  end

  def purchase(origin, destination, passenger)
    return true if super(origin, destination, passenger)
    @rejected << RejectedTicket.new(origin, destination, passenger)
    false
  end

  attr_reader :rejected
end
