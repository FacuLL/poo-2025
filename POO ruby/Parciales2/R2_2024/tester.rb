class LapTracker

  attr_reader :times_by_circuit

  def initialize
    @times_by_circuit = Hash.new
  end

  def record_lap?(circuit, pilot, time, lap)
    circuit?(circuit) && pilot?(pilot) && time.positive? && lap.positive?
  end

  def record_lap(circuit, pilot, time, lap)
    raise "Cannot Record Lap" unless record_lap?(circuit, pilot, time, lap)
    @times_by_circuit[circuit] = Hash.new if @times_by_circuit[circuit].nil?
    @times_by_circuit[circuit][pilot] = PilotLap.new(pilot, lap, time)
  end

  def results
    s = "Results:\n"
    @times_by_circuit.keys.sort.each do |circuit|
      s += "*** Circuit #{circuit}\n"
      @times_by_circuit[circuit].values.sort.each do |pilot_lap|
        s += "-> Pilot #{pilot_lap}\n"
      end
    end
    s
  end


  def circuit?(circuit) = circuit.include?('GP')


  def pilot?(pilot) = pilot.ascii_only? # falso si contiene !, á, etc.
end


class LapLimitedTracker < LapTracker
  def initialize
    super
  end

  def lap_empty?(circuit, pilot)
    self.times_by_circuit[circuit].nil? || self.times_by_circuit[circuit][pilot].nil?
  end

  def record_lap?(circuit, pilot, time, lap)
    super && (lap_empty?(circuit, pilot) || self.times_by_circuit[circuit][pilot].lap < lap)
  end
end

class TimeLimitedTracker < LapLimitedTracker
  def initialize
    super
  end

  def record_lap?(circuit, pilot, time, lap)
    super && (lap_empty?(circuit, pilot) || self.times_by_circuit[circuit][pilot].time > time)
  end
end

class PilotLap
  attr_reader :lap, :time, :name

  def initialize(name, lap, time)
    @name = name
    @lap = lap
    @time = time
  end

  def to_s
    "#{@name} with #{time}s on lap #{lap}"
  end

  def <=>(other)
    [@time, other.name] <=> [other.time, @name]
  end

end


# Se instancia el sistema para registrar los tiempos de vueltas donde para un circuito y piloto # sólo se registra el de la última invocación
lap_tracker = LapTracker.new
lap_tracker.record_lap('GP Las Vegas', 'Lewis Hamilton', 95.8, 12)
lap_tracker.record_lap('GP Las Vegas', 'Franco Colapinto', 94.6, 18)
lap_tracker.record_lap('GP Las Vegas', 'Lewis Hamilton', 97.9, 10)
lap_tracker.record_lap('GP Las Vegas', 'Max Verstappen', 97.9, 10)
lap_tracker.record_lap('GP Montreal', 'Lewis Hamilton', 75.3, 25)
lap_tracker.record_lap('GP Montreal', 'Max Verstappen', 75.3, 16)
begin # Se arroja error porque el circuito es inválido
  lap_tracker.record_lap('Las Vegas', 'Lewis Hamilton', 96.1, 12)
rescue => e
  puts e.message # Cannot Record Lap
end
puts lap_tracker.results # Alfab. por circuito, asc. por tiempo y desc. por piloto
# Results:
# *** Circuit GP Las Vegas
# -> Pilot Franco Colapinto with 94.6s on lap 18
# -> Pilot Max Verstappen with 97.9s on lap 10
# -> Pilot Lewis Hamilton with 97.9s on lap 10
# *** Circuit GP Montreal
# -> Pilot Max Verstappen with 75.3s on lap 16
# -> Pilot Lewis Hamilton with 75.3s on lap 25


# Se instancia el sistema para registrar los tiempos de vueltas donde para un circuito y piloto
# sólo se registra si el número de vuelta es mayor al ya registrado o es la primera invocación
latest_lap_tracker = LapLimitedTracker.new
  latest_lap_tracker.record_lap('GP Las Vegas', 'Lewis Hamilton', 95.8, 12)
latest_lap_tracker.record_lap('GP Las Vegas', 'Franco Colapinto', 94.6, 18)
begin # Se arroja error porque la vuelta 10 no es mayor a la 12 ya registrada
  latest_lap_tracker.record_lap('GP Las Vegas', 'Lewis Hamilton', 97.9, 10)
rescue => e
  puts e.message # Cannot Record Lap
end
latest_lap_tracker.record_lap('GP Las Vegas', 'Lewis Hamilton', 98.8, 14)
latest_lap_tracker.record_lap('GP Las Vegas', 'Max Verstappen', 97.9, 10)
latest_lap_tracker.record_lap('GP Montreal', 'Lewis Hamilton', 75.3, 25)
latest_lap_tracker.record_lap('GP Montreal', 'Max Verstappen', 75.3, 16)
begin # Se arroja error porque el piloto contiene caracteres especiales
  latest_lap_tracker.record_lap('GP Montreal', 'Máx! Verstappen', 74.9, 20)
rescue => e
  puts e.message # Cannot Record Lap
end
puts latest_lap_tracker.results # Alfab. por circuito, asc. por tiempo y desc. por piloto
# Results:
# *** Circuit GP Las Vegas
# -> Pilot Franco Colapinto with 94.6s on lap 18
# -> Pilot Max Verstappen with 97.9s on lap 10
# -> Pilot Lewis Hamilton with 98.8s on lap 14
# *** Circuit GP Montreal
# -> Pilot Max Verstappen with 75.3s on lap 16
# -> Pilot Lewis Hamilton with 75.3s on lap 25
# Se instancia el sistema para registrar los tiempos de vueltas donde para un circuito y piloto
# sólo se registra si el número de vuelta es mayor al ya registrado
# y el tiempo es menor al ya registrado
# o es la primera vez que se registra
fastest_lap_tracker = TimeLimitedTracker.new
  fastest_lap_tracker.record_lap('GP Las Vegas', 'Lewis Hamilton', 95.8, 12)
fastest_lap_tracker.record_lap('GP Las Vegas', 'Franco Colapinto', 94.6, 18)
begin # Se arroja error porque el tiempo de la vuelta 14 no es menor al de la 12 ya registrado
  fastest_lap_tracker.record_lap('GP Las Vegas', 'Lewis Hamilton', 97.9, 14)
rescue => e
  puts e.message # Cannot Record Lap
end
fastest_lap_tracker.record_lap('GP Las Vegas', 'Lewis Hamilton', 92.5, 16)
fastest_lap_tracker.record_lap('GP Las Vegas', 'Max Verstappen', 97.9, 10)
fastest_lap_tracker.record_lap('GP Montreal', 'Lewis Hamilton', 75.3, 25)
fastest_lap_tracker.record_lap('GP Montreal', 'Max Verstappen', 75.3, 16)
begin # Se arroja error porque la vuelta no es positiva
  fastest_lap_tracker.record_lap('GP Montreal', 'Max Verstappen', 3.14, -5)
rescue => e
  puts e.message # Cannot Record Lap
end
puts fastest_lap_tracker.results # Alfab. por circuito, asc. por tiempo y desc. por piloto
# Results:
# *** Circuit GP Las Vegas
# -> Pilot Lewis Hamilton with 92.5s on lap 16
# -> Pilot Franco Colapinto with 94.6s on lap 18
# -> Pilot Max Verstappen with 97.9s on lap 10
# *** Circuit GP Montreal
# -> Pilot Max Verstappen with 75.3s on lap 16
# -> Pilot Lewis Hamilton with 75.3s on lap 25

