# frozen_string_literal: true
require_relative 'theme_park_passholders'

class ParkLimitedThemParkPassholders < ThemeParkPassholders
  def initialize(visitor, included_parks)
    super(visitor)
    @included_parks = included_parks
  end

  def park_already_added?(theme_park)
    self.passes.each do
      return true if theme_park == it.theme_park
    end
    false
  end

  def add_pass?(theme_park, day)
    super(theme_park, day) && not park_already_added?(theme_park) && @included_parks.include?(theme_park)
  end

  private :add_pass?
end
