# frozen_string_literal: true

class ThemeParkPass
  def initialize(theme_park, day)
    @theme_park = theme_park
    @day = day
  end

  def to_s
    "#{@theme_park} on day #{@day}"
  end

  def <=>(other)
    [other.day, @theme_park] <=> [@day, other.theme_park]
  end

  attr_reader :day, :theme_park
  alias_method :inspect, :to_s
end
