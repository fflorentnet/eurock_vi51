package fr.utbm.vi51.project.eurock.agent;

import com.google.common.base.Objects;
import fr.utbm.info.vi51.framework.agent.AbstractAnimat;
import fr.utbm.info.vi51.framework.agent.BehaviourOutput;
import fr.utbm.info.vi51.framework.environment.PerceptionEvent;
import fr.utbm.info.vi51.framework.environment.SimulationAgentReady;
import fr.utbm.info.vi51.framework.math.MathUtil;
import fr.utbm.info.vi51.framework.math.Point2f;
import fr.utbm.info.vi51.framework.math.Vector2f;
import fr.utbm.vi51.project.eurock.behaviour2.AlertBehaviour;
import fr.utbm.vi51.project.eurock.behaviour2.FleeBehaviour;
import fr.utbm.vi51.project.eurock.behaviour2.SeekBehaviour;
import fr.utbm.vi51.project.eurock.behaviour2.SteeringFleeBehaviour;
import fr.utbm.vi51.project.eurock.behaviour2.SteeringSeekBehaviour;
import fr.utbm.vi51.project.eurock.behaviour2.SteeringWanderBehaviour;
import fr.utbm.vi51.project.eurock.influence.TypeChangeInfluence;
import io.sarl.core.AgentSpawned;
import io.sarl.core.DefaultContextInteractions;
import io.sarl.core.Initialize;
import io.sarl.lang.annotation.FiredEvent;
import io.sarl.lang.annotation.Generated;
import io.sarl.lang.annotation.ImportedCapacityFeature;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.AgentContext;
import io.sarl.lang.core.Event;
import io.sarl.lang.core.EventSpace;
import io.sarl.lang.core.Percept;
import io.sarl.lang.core.Scope;
import io.sarl.lang.core.Space;
import io.sarl.lang.core.SpaceID;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Nicolas
 */
@SuppressWarnings("all")
public class Spectator extends AbstractAnimat {
  protected FleeBehaviour fleeBehaviour;
  
  protected SeekBehaviour seekBehaviourExit;
  
  protected SeekBehaviour seekBehaviourScene;
  
  protected SeekBehaviour seekBehaviourStand;
  
  protected SteeringWanderBehaviour wanderBehaviour;
  
  protected AlertBehaviour alertBehaviour;
  
  protected final float STOP_RADIUS = (MathUtil.PI / 10f);
  
  protected final float SLOW_RADIUS = (MathUtil.PI / 4f);
  
  protected final float WANDER_CIRCLE_DISTANCE = 20f;
  
  protected final float WANDER_CIRCLE_RADIUS = 10f;
  
  protected final float WANDER_MAX_ROTATION = (MathUtil.PI / 4f);
  
  protected final float ALERT_RADIUS = 5f;
  
  /**
   * The spectator waits for a new concert begins
   */
  @Percept
  public void _handle_Initialize_0(final Initialize occurrence) {
    super._handle_Initialize_0(occurrence);
    SteeringFleeBehaviour _steeringFleeBehaviour = new SteeringFleeBehaviour();
    this.fleeBehaviour = _steeringFleeBehaviour;
    SteeringSeekBehaviour _steeringSeekBehaviour = new SteeringSeekBehaviour();
    this.seekBehaviourExit = _steeringSeekBehaviour;
    SteeringSeekBehaviour _steeringSeekBehaviour_1 = new SteeringSeekBehaviour();
    this.seekBehaviourScene = _steeringSeekBehaviour_1;
    SteeringSeekBehaviour _steeringSeekBehaviour_2 = new SteeringSeekBehaviour();
    this.seekBehaviourStand = _steeringSeekBehaviour_2;
    SteeringWanderBehaviour _steeringWanderBehaviour = new SteeringWanderBehaviour(
      this.WANDER_CIRCLE_DISTANCE, 
      this.WANDER_CIRCLE_RADIUS, 
      this.WANDER_MAX_ROTATION, 
      this.STOP_RADIUS, 
      this.SLOW_RADIUS);
    this.wanderBehaviour = _steeringWanderBehaviour;
    AlertBehaviour _alertBehaviour = new AlertBehaviour();
    this.alertBehaviour = _alertBehaviour;
    SimulationAgentReady _simulationAgentReady = new SimulationAgentReady();
    this.emit(_simulationAgentReady);
  }
  
  @Percept
  public void _handle_PerceptionEvent_1(final PerceptionEvent occurrence) {
    fr.utbm.info.vi51.framework.environment.Percept target = this.first(occurrence.perceptions);
    Serializable _type = target.getType();
    boolean _tripleEquals = (_type == "ALERT");
    if (_tripleEquals) {
      BehaviourOutput _runAlert = this.alertBehaviour.runAlert(
        this.ALERT_RADIUS);
      TypeChangeInfluence _typeChangeInfluence = new TypeChangeInfluence("SCARED");
      this.emitInfluence(_runAlert, _typeChangeInfluence);
    } else {
      Serializable _type_1 = target.getType();
      boolean _tripleEquals_1 = (_type_1 == "EXIT");
      if (_tripleEquals_1) {
        Point2f _position = occurrence.body.getPosition();
        float _currentLinearSpeed = occurrence.body.getCurrentLinearSpeed();
        float _maxLinear = this.getMaxLinear(occurrence.body);
        Point2f _position_1 = target.getPosition();
        BehaviourOutput _runSeek = this.seekBehaviourExit.runSeek(_position, _currentLinearSpeed, _maxLinear, _position_1);
        TypeChangeInfluence _typeChangeInfluence_1 = new TypeChangeInfluence("CALM");
        this.emitInfluence(_runSeek, _typeChangeInfluence_1);
      } else {
        Serializable _type_2 = target.getType();
        boolean _tripleEquals_2 = (_type_2 == "BOMB");
        if (_tripleEquals_2) {
          Point2f _position_2 = occurrence.body.getPosition();
          float _currentLinearSpeed_1 = occurrence.body.getCurrentLinearSpeed();
          float _maxLinear_1 = this.getMaxLinear(occurrence.body);
          Point2f _position_3 = target.getPosition();
          BehaviourOutput _runFlee = this.fleeBehaviour.runFlee(_position_2, _currentLinearSpeed_1, _maxLinear_1, _position_3);
          TypeChangeInfluence _typeChangeInfluence_2 = new TypeChangeInfluence("SCARED");
          this.emitInfluence(_runFlee, _typeChangeInfluence_2);
        } else {
          Serializable _type_3 = target.getType();
          boolean _tripleEquals_3 = (_type_3 == "SCENE");
          if (_tripleEquals_3) {
            Point2f _position_4 = occurrence.body.getPosition();
            float _currentLinearSpeed_2 = occurrence.body.getCurrentLinearSpeed();
            float _maxLinear_2 = this.getMaxLinear(occurrence.body);
            Point2f _position_5 = target.getPosition();
            BehaviourOutput _runSeek_1 = this.seekBehaviourScene.runSeek(_position_4, _currentLinearSpeed_2, _maxLinear_2, _position_5);
            TypeChangeInfluence _typeChangeInfluence_3 = new TypeChangeInfluence("WATCHING");
            this.emitInfluence(_runSeek_1, _typeChangeInfluence_3);
          } else {
            Serializable _type_4 = target.getType();
            boolean _tripleEquals_4 = (_type_4 == "STAND");
            if (_tripleEquals_4) {
              Point2f _position_6 = occurrence.body.getPosition();
              float _currentLinearSpeed_3 = occurrence.body.getCurrentLinearSpeed();
              float _maxLinear_3 = this.getMaxLinear(occurrence.body);
              Point2f _position_7 = target.getPosition();
              BehaviourOutput _runSeek_2 = this.seekBehaviourStand.runSeek(_position_6, _currentLinearSpeed_3, _maxLinear_3, _position_7);
              TypeChangeInfluence _typeChangeInfluence_4 = new TypeChangeInfluence("HUNGRY");
              this.emitInfluence(_runSeek_2, _typeChangeInfluence_4);
            } else {
              boolean _equals = Objects.equal(target, null);
              if (_equals) {
                Point2f _position_8 = occurrence.body.getPosition();
                Vector2f _direction = occurrence.body.getDirection();
                float _currentLinearSpeed_4 = occurrence.body.getCurrentLinearSpeed();
                float _maxLinear_4 = this.getMaxLinear(occurrence.body);
                float _currentAngularSpeed = occurrence.body.getCurrentAngularSpeed();
                float _maxAngular = this.getMaxAngular(occurrence.body);
                BehaviourOutput _runWander = this.wanderBehaviour.runWander(_position_8, _direction, _currentLinearSpeed_4, _maxLinear_4, _currentAngularSpeed, _maxAngular);
                TypeChangeInfluence _typeChangeInfluence_5 = new TypeChangeInfluence("CALM");
                this.emitInfluence(_runWander, _typeChangeInfluence_5);
              }
            }
          }
        }
      }
    }
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#emit(io.sarl.lang.core.Event)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#emit(io.sarl.lang.core.Event)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected void emit(final Event e) {
    getSkill(io.sarl.core.DefaultContextInteractions.class).emit(e);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#emit(io.sarl.lang.core.Event,io.sarl.lang.core.Scope<io.sarl.lang.core.Address>)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#emit(io.sarl.lang.core.Event,io.sarl.lang.core.Scope<io.sarl.lang.core.Address>)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected void emit(final Event e, final Scope<Address> scope) {
    getSkill(io.sarl.core.DefaultContextInteractions.class).emit(e, scope);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#getDefaultAddress()}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#getDefaultAddress()
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected Address getDefaultAddress() {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).getDefaultAddress();
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#getDefaultContext()}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#getDefaultContext()
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected AgentContext getDefaultContext() {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).getDefaultContext();
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#getDefaultSpace()}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#getDefaultSpace()
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected EventSpace getDefaultSpace() {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).getDefaultSpace();
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isDefaultContext(io.sarl.lang.core.AgentContext)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isDefaultContext(io.sarl.lang.core.AgentContext)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isDefaultContext(final AgentContext context) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isDefaultContext(context);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isDefaultContext(java.util.UUID)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isDefaultContext(java.util.UUID)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isDefaultContext(final UUID contextID) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isDefaultContext(contextID);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isDefaultSpace(io.sarl.lang.core.Space)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isDefaultSpace(io.sarl.lang.core.Space)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isDefaultSpace(final Space space) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isDefaultSpace(space);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isDefaultSpace(io.sarl.lang.core.SpaceID)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isDefaultSpace(io.sarl.lang.core.SpaceID)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isDefaultSpace(final SpaceID space) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isDefaultSpace(space);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isDefaultSpace(java.util.UUID)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isDefaultSpace(java.util.UUID)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isDefaultSpace(final UUID space) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isDefaultSpace(space);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isInDefaultSpace(io.sarl.lang.core.Event)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isInDefaultSpace(io.sarl.lang.core.Event)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isInDefaultSpace(final Event event) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isInDefaultSpace(event);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#receive(java.util.UUID,io.sarl.lang.core.Event)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#receive(java.util.UUID,io.sarl.lang.core.Event)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected void receive(final UUID receiver, final Event e) {
    getSkill(io.sarl.core.DefaultContextInteractions.class).receive(receiver, e);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#spawn(java.lang.Class<? extends io.sarl.lang.core.Agent>,java.lang.Object[])}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#spawn(java.lang.Class<? extends io.sarl.lang.core.Agent>,java.lang.Object[])
   */
  @FiredEvent(AgentSpawned.class)
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected UUID spawn(final Class<? extends Agent> aAgent, final Object... params) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).spawn(aAgent, params);
  }
  
  /**
   * Construct an agent.
   * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
   */
  @Generated
  public Spectator(final UUID parentID) {
    super(parentID, null);
  }
  
  /**
   * Construct an agent.
   * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
   * @param agentID - identifier of the agent. If <code>null</code> the agent identifier will be computed randomly.
   */
  @Generated
  public Spectator(final UUID parentID, final UUID agentID) {
    super(parentID, agentID);
  }
}
