// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: src/main/protobuf/job.proto
// Protobuf Java Version: 4.27.0

/**
 * Protobuf service {@code JobService}
 */
public  abstract class JobService
    implements com.google.protobuf.Service {
  protected JobService() {}

  public interface Interface {
    /**
     * <code>rpc GetAll(.GetAllRequest) returns (.GetAllResponse);</code>
     */
    public abstract void getAll(
        com.google.protobuf.RpcController controller,
        GetAllRequest request,
        com.google.protobuf.RpcCallback<GetAllResponse> done);

  }

  public static com.google.protobuf.Service newReflectiveService(
      final Interface impl) {
    return new JobService() {
      @java.lang.Override
      public  void getAll(
          com.google.protobuf.RpcController controller,
          GetAllRequest request,
          com.google.protobuf.RpcCallback<GetAllResponse> done) {
        impl.getAll(controller, request, done);
      }

    };
  }

  public static com.google.protobuf.BlockingService
      newReflectiveBlockingService(final BlockingInterface impl) {
    return new com.google.protobuf.BlockingService() {
      public final com.google.protobuf.Descriptors.ServiceDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }

      public final com.google.protobuf.Message callBlockingMethod(
          com.google.protobuf.Descriptors.MethodDescriptor method,
          com.google.protobuf.RpcController controller,
          com.google.protobuf.Message request)
          throws com.google.protobuf.ServiceException {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.callBlockingMethod() given method descriptor for " +
            "wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return impl.getAll(controller, (GetAllRequest)request);
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

      public final com.google.protobuf.Message
          getRequestPrototype(
          com.google.protobuf.Descriptors.MethodDescriptor method) {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.getRequestPrototype() given method " +
            "descriptor for wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return GetAllRequest.getDefaultInstance();
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

      public final com.google.protobuf.Message
          getResponsePrototype(
          com.google.protobuf.Descriptors.MethodDescriptor method) {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.getResponsePrototype() given method " +
            "descriptor for wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return GetAllResponse.getDefaultInstance();
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

    };
  }

  /**
   * <code>rpc GetAll(.GetAllRequest) returns (.GetAllResponse);</code>
   */
  public abstract void getAll(
      com.google.protobuf.RpcController controller,
      GetAllRequest request,
      com.google.protobuf.RpcCallback<GetAllResponse> done);

  public static final
      com.google.protobuf.Descriptors.ServiceDescriptor
      getDescriptor() {
    return Job.getDescriptor().getServices().get(0);
  }
  public final com.google.protobuf.Descriptors.ServiceDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }

  public final void callMethod(
      com.google.protobuf.Descriptors.MethodDescriptor method,
      com.google.protobuf.RpcController controller,
      com.google.protobuf.Message request,
      com.google.protobuf.RpcCallback<
        com.google.protobuf.Message> done) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.callMethod() given method descriptor for wrong " +
        "service type.");
    }
    switch(method.getIndex()) {
      case 0:
        this.getAll(controller, (GetAllRequest)request,
          com.google.protobuf.RpcUtil.<GetAllResponse>specializeCallback(
            done));
        return;
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public final com.google.protobuf.Message
      getRequestPrototype(
      com.google.protobuf.Descriptors.MethodDescriptor method) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.getRequestPrototype() given method " +
        "descriptor for wrong service type.");
    }
    switch(method.getIndex()) {
      case 0:
        return GetAllRequest.getDefaultInstance();
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public final com.google.protobuf.Message
      getResponsePrototype(
      com.google.protobuf.Descriptors.MethodDescriptor method) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.getResponsePrototype() given method " +
        "descriptor for wrong service type.");
    }
    switch(method.getIndex()) {
      case 0:
        return GetAllResponse.getDefaultInstance();
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public static Stub newStub(
      com.google.protobuf.RpcChannel channel) {
    return new Stub(channel);
  }

  public static final class Stub extends JobService implements Interface {
    private Stub(com.google.protobuf.RpcChannel channel) {
      this.channel = channel;
    }

    private final com.google.protobuf.RpcChannel channel;

    public com.google.protobuf.RpcChannel getChannel() {
      return channel;
    }

    public  void getAll(
        com.google.protobuf.RpcController controller,
        GetAllRequest request,
        com.google.protobuf.RpcCallback<GetAllResponse> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(0),
        controller,
        request,
        GetAllResponse.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          GetAllResponse.class,
          GetAllResponse.getDefaultInstance()));
    }
  }

  public static BlockingInterface newBlockingStub(
      com.google.protobuf.BlockingRpcChannel channel) {
    return new BlockingStub(channel);
  }

  public interface BlockingInterface {
    public GetAllResponse getAll(
        com.google.protobuf.RpcController controller,
        GetAllRequest request)
        throws com.google.protobuf.ServiceException;
  }

  private static final class BlockingStub implements BlockingInterface {
    private BlockingStub(com.google.protobuf.BlockingRpcChannel channel) {
      this.channel = channel;
    }

    private final com.google.protobuf.BlockingRpcChannel channel;

    public GetAllResponse getAll(
        com.google.protobuf.RpcController controller,
        GetAllRequest request)
        throws com.google.protobuf.ServiceException {
      return (GetAllResponse) channel.callBlockingMethod(
        getDescriptor().getMethods().get(0),
        controller,
        request,
        GetAllResponse.getDefaultInstance());
    }

  }

  // @@protoc_insertion_point(class_scope:JobService)
}

