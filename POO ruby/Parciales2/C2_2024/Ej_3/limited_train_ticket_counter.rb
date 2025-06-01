# frozen_string_literal: true
require_relative 'train_ticket_counter'

class LimitedTrainTicketCounter < TrainTicketCounter
  def initialize(max_sales, station)
    super()
    @station = station
    @max_sales = max_sales
    @sales = 0
  end

  def purchase(origin, destination, passenger)
    return false unless origin == @station
    return false unless @sales < @max_sales
    return false unless super(origin, destination, passenger)
    @sales+=1
    true
  end
end
