package gln

import gli_.gl
import glm_.L
import glm_.vec3.Vec3i
import gln.objects.GlTexture
import kool.Ptr
import kool.adr
import org.lwjgl.opengl.GL43C
import org.lwjgl.system.MemoryUtil.NULL
import java.nio.Buffer

/**
 * The OpenGL functionality up to version 4.3. Includes only Core Profile symbols.
 *
 * <p>OpenGL 4.3 implementations support revision 4.30 of the OpenGL Shading Language.</p>
 *
 * <p>Extensions promoted to core in this release:</p>
 *
 * <ul>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_arrays_of_arrays.txt">ARB_arrays_of_arrays</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_ES3_compatibility.txt">ARB_ES3_compatibility</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_clear_buffer_object.txt">ARB_clear_buffer_object</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_compute_shader.txt">ARB_compute_shader</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_copy_image.txt">ARB_copy_image</a></li>
 * <li>{@code ARB_debug_group}</li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/EXT/EXT_debug_label.txt">EXT_debug_label</a></li>
 * <li>{@code ARB_debug_output2}</li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_debug_output.txt">ARB_debug_output</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_explicit_uniform_location.txt">ARB_explicit_uniform_location</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_fragment_layer_viewport.txt">ARB_fragment_layer_viewport</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_framebuffer_no_attachments.txt">ARB_framebuffer_no_attachments</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_internalformat_query2.txt">ARB_internalformat_query2</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_invalidate_subdata.txt">ARB_invalidate_subdata</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_multi_draw_indirect.txt">ARB_multi_draw_indirect</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_program_interface_query.txt">ARB_program_interface_query</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_robust_buffer_access_behavior.txt">ARB_robust_buffer_access_behavior</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_shader_image_size.txt">ARB_shader_image_size</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_shader_storage_buffer_object.txt">ARB_shader_storage_buffer_object</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_stencil_texturing.txt">ARB_stencil_texturing</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_texture_buffer_range.txt">ARB_texture_buffer_range</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_texture_query_levels.txt">ARB_texture_query_levels</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_texture_storage_multisample.txt">ARB_texture_storage_multisample</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_texture_view.txt">ARB_texture_view</a></li>
 * <li><a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_vertex_attrib_binding.txt">ARB_vertex_attrib_binding</a></li>
 * </ul>
 */
interface gl43i {

    // --- [ glClearBufferData ] ---

    /**
     * Fills a buffer object's data store with a fixed value.
     *
     * @param target         the target of the operation. One of:<br><table><tr><td>{@link GL15#GL_ARRAY_BUFFER ARRAY_BUFFER}</td><td>{@link GL15#GL_ELEMENT_ARRAY_BUFFER ELEMENT_ARRAY_BUFFER}</td><td>{@link GL21#GL_PIXEL_PACK_BUFFER PIXEL_PACK_BUFFER}</td><td>{@link GL21#GL_PIXEL_UNPACK_BUFFER PIXEL_UNPACK_BUFFER}</td></tr><tr><td>{@link GL30#GL_TRANSFORM_FEEDBACK_BUFFER TRANSFORM_FEEDBACK_BUFFER}</td><td>{@link GL31#GL_UNIFORM_BUFFER UNIFORM_BUFFER}</td><td>{@link GL31#GL_TEXTURE_BUFFER TEXTURE_BUFFER}</td><td>{@link GL31#GL_COPY_READ_BUFFER COPY_READ_BUFFER}</td></tr><tr><td>{@link GL31#GL_COPY_WRITE_BUFFER COPY_WRITE_BUFFER}</td><td>{@link GL40#GL_DRAW_INDIRECT_BUFFER DRAW_INDIRECT_BUFFER}</td><td>{@link GL42#GL_ATOMIC_COUNTER_BUFFER ATOMIC_COUNTER_BUFFER}</td><td>{@link #GL_DISPATCH_INDIRECT_BUFFER DISPATCH_INDIRECT_BUFFER}</td></tr><tr><td>{@link #GL_SHADER_STORAGE_BUFFER SHADER_STORAGE_BUFFER}</td><td>{@link ARBIndirectParameters#GL_PARAMETER_BUFFER_ARB PARAMETER_BUFFER_ARB}</td></tr></table>
     * @param internalFormat the internal format with which the data will be stored in the buffer object
     * @param format         the format of the data in memory addressed by {@code data}. One of:<br><table><tr><td>{@link GL11#GL_RED RED}</td><td>{@link GL11#GL_GREEN GREEN}</td><td>{@link GL11#GL_BLUE BLUE}</td><td>{@link GL11#GL_ALPHA ALPHA}</td><td>{@link GL30#GL_RG RG}</td><td>{@link GL11#GL_RGB RGB}</td><td>{@link GL11C#GL_RGBA RGBA}</td><td>{@link GL12#GL_BGR BGR}</td></tr><tr><td>{@link GL12#GL_BGRA BGRA}</td><td>{@link GL30#GL_RED_INTEGER RED_INTEGER}</td><td>{@link GL30#GL_GREEN_INTEGER GREEN_INTEGER}</td><td>{@link GL30#GL_BLUE_INTEGER BLUE_INTEGER}</td><td>{@link GL30#GL_ALPHA_INTEGER ALPHA_INTEGER}</td><td>{@link GL30#GL_RG_INTEGER RG_INTEGER}</td><td>{@link GL30#GL_RGB_INTEGER RGB_INTEGER}</td><td>{@link GL30#GL_RGBA_INTEGER RGBA_INTEGER}</td></tr><tr><td>{@link GL30#GL_BGR_INTEGER BGR_INTEGER}</td><td>{@link GL30#GL_BGRA_INTEGER BGRA_INTEGER}</td><td>{@link GL11#GL_STENCIL_INDEX STENCIL_INDEX}</td><td>{@link GL11#GL_DEPTH_COMPONENT DEPTH_COMPONENT}</td><td>{@link GL30#GL_DEPTH_STENCIL DEPTH_STENCIL}</td><td>{@link GL11#GL_LUMINANCE LUMINANCE}</td><td>{@link GL11#GL_LUMINANCE_ALPHA LUMINANCE_ALPHA}</td></tr></table>
     * @param type           the type of the data in memory addressed by {@code data}. One of:<br><table><tr><td>{@link GL11#GL_UNSIGNED_BYTE UNSIGNED_BYTE}</td><td>{@link GL11#GL_BYTE BYTE}</td><td>{@link GL11#GL_UNSIGNED_SHORT UNSIGNED_SHORT}</td><td>{@link GL11#GL_SHORT SHORT}</td></tr><tr><td>{@link GL11#GL_UNSIGNED_INT UNSIGNED_INT}</td><td>{@link GL11#GL_INT INT}</td><td>{@link GL30#GL_HALF_FLOAT HALF_FLOAT}</td><td>{@link GL11#GL_FLOAT FLOAT}</td></tr><tr><td>{@link GL12#GL_UNSIGNED_BYTE_3_3_2 UNSIGNED_BYTE_3_3_2}</td><td>{@link GL12#GL_UNSIGNED_BYTE_2_3_3_REV UNSIGNED_BYTE_2_3_3_REV}</td><td>{@link GL12#GL_UNSIGNED_SHORT_5_6_5 UNSIGNED_SHORT_5_6_5}</td><td>{@link GL12#GL_UNSIGNED_SHORT_5_6_5_REV UNSIGNED_SHORT_5_6_5_REV}</td></tr><tr><td>{@link GL12#GL_UNSIGNED_SHORT_4_4_4_4 UNSIGNED_SHORT_4_4_4_4}</td><td>{@link GL12#GL_UNSIGNED_SHORT_4_4_4_4_REV UNSIGNED_SHORT_4_4_4_4_REV}</td><td>{@link GL12#GL_UNSIGNED_SHORT_5_5_5_1 UNSIGNED_SHORT_5_5_5_1}</td><td>{@link GL12#GL_UNSIGNED_SHORT_1_5_5_5_REV UNSIGNED_SHORT_1_5_5_5_REV}</td></tr><tr><td>{@link GL12#GL_UNSIGNED_INT_8_8_8_8 UNSIGNED_INT_8_8_8_8}</td><td>{@link GL12#GL_UNSIGNED_INT_8_8_8_8_REV UNSIGNED_INT_8_8_8_8_REV}</td><td>{@link GL12#GL_UNSIGNED_INT_10_10_10_2 UNSIGNED_INT_10_10_10_2}</td><td>{@link GL12#GL_UNSIGNED_INT_2_10_10_10_REV UNSIGNED_INT_2_10_10_10_REV}</td></tr><tr><td>{@link GL30#GL_UNSIGNED_INT_24_8 UNSIGNED_INT_24_8}</td><td>{@link GL30#GL_UNSIGNED_INT_10F_11F_11F_REV UNSIGNED_INT_10F_11F_11F_REV}</td><td>{@link GL30#GL_UNSIGNED_INT_5_9_9_9_REV UNSIGNED_INT_5_9_9_9_REV}</td><td>{@link GL30#GL_FLOAT_32_UNSIGNED_INT_24_8_REV FLOAT_32_UNSIGNED_INT_24_8_REV}</td></tr><tr><td>{@link GL11#GL_BITMAP BITMAP}</td></tr></table>
     * @param data           the buffer containing the data to be used as the source of the constant fill value. The elements of data are converted by the GL into the format
     *                       specified by internalFormat, and then used to fill the specified range of the destination buffer. If data is {@code NULL}, then it is ignored and the
     *                       sub-range of the buffer is filled with zeros.
     *
     * @see <a target="_blank" href="http://docs.gl/gl4/glClearBufferData">Reference Page</a>
     */
    fun clearBufferData(target: BufferTarget, internalFormat: InternalFormat, format: gl.ExternalFormat, type: gl.TypeFormat, data: Buffer? = null) =
        GL43C.nglClearBufferData(target.i, internalFormat.i, format.i, type.i, data?.adr ?: NULL)

    // --- [ glClearBufferSubData ] ---

    /**
     * Fills all or part of buffer object's data store with a fixed value.
     *
     * @param target         the target of the operation. One of:<br><table><tr><td>{@link GL15#GL_ARRAY_BUFFER ARRAY_BUFFER}</td><td>{@link GL15#GL_ELEMENT_ARRAY_BUFFER ELEMENT_ARRAY_BUFFER}</td><td>{@link GL21#GL_PIXEL_PACK_BUFFER PIXEL_PACK_BUFFER}</td><td>{@link GL21#GL_PIXEL_UNPACK_BUFFER PIXEL_UNPACK_BUFFER}</td></tr><tr><td>{@link GL30#GL_TRANSFORM_FEEDBACK_BUFFER TRANSFORM_FEEDBACK_BUFFER}</td><td>{@link GL31#GL_UNIFORM_BUFFER UNIFORM_BUFFER}</td><td>{@link GL31#GL_TEXTURE_BUFFER TEXTURE_BUFFER}</td><td>{@link GL31#GL_COPY_READ_BUFFER COPY_READ_BUFFER}</td></tr><tr><td>{@link GL31#GL_COPY_WRITE_BUFFER COPY_WRITE_BUFFER}</td><td>{@link GL40#GL_DRAW_INDIRECT_BUFFER DRAW_INDIRECT_BUFFER}</td><td>{@link GL42#GL_ATOMIC_COUNTER_BUFFER ATOMIC_COUNTER_BUFFER}</td><td>{@link #GL_DISPATCH_INDIRECT_BUFFER DISPATCH_INDIRECT_BUFFER}</td></tr><tr><td>{@link #GL_SHADER_STORAGE_BUFFER SHADER_STORAGE_BUFFER}</td><td>{@link ARBIndirectParameters#GL_PARAMETER_BUFFER_ARB PARAMETER_BUFFER_ARB}</td></tr></table>
     * @param internalFormat the internal format with which the data will be stored in the buffer object
     * @param offset         the offset, in basic machine units into the buffer object's data store at which to start filling
     * @param size           the size, in basic machine units of the range of the data store to fill
     * @param format         the format of the data in memory addressed by {@code data}. One of:<br><table><tr><td>{@link GL11#GL_RED RED}</td><td>{@link GL11#GL_GREEN GREEN}</td><td>{@link GL11#GL_BLUE BLUE}</td><td>{@link GL11#GL_ALPHA ALPHA}</td><td>{@link GL30#GL_RG RG}</td><td>{@link GL11#GL_RGB RGB}</td><td>{@link GL11C#GL_RGBA RGBA}</td><td>{@link GL12#GL_BGR BGR}</td></tr><tr><td>{@link GL12#GL_BGRA BGRA}</td><td>{@link GL30#GL_RED_INTEGER RED_INTEGER}</td><td>{@link GL30#GL_GREEN_INTEGER GREEN_INTEGER}</td><td>{@link GL30#GL_BLUE_INTEGER BLUE_INTEGER}</td><td>{@link GL30#GL_ALPHA_INTEGER ALPHA_INTEGER}</td><td>{@link GL30#GL_RG_INTEGER RG_INTEGER}</td><td>{@link GL30#GL_RGB_INTEGER RGB_INTEGER}</td><td>{@link GL30#GL_RGBA_INTEGER RGBA_INTEGER}</td></tr><tr><td>{@link GL30#GL_BGR_INTEGER BGR_INTEGER}</td><td>{@link GL30#GL_BGRA_INTEGER BGRA_INTEGER}</td><td>{@link GL11#GL_STENCIL_INDEX STENCIL_INDEX}</td><td>{@link GL11#GL_DEPTH_COMPONENT DEPTH_COMPONENT}</td><td>{@link GL30#GL_DEPTH_STENCIL DEPTH_STENCIL}</td><td>{@link GL11#GL_LUMINANCE LUMINANCE}</td><td>{@link GL11#GL_LUMINANCE_ALPHA LUMINANCE_ALPHA}</td></tr></table>
     * @param type           the type of the data in memory addressed by {@code data}. One of:<br><table><tr><td>{@link GL11#GL_UNSIGNED_BYTE UNSIGNED_BYTE}</td><td>{@link GL11#GL_BYTE BYTE}</td><td>{@link GL11#GL_UNSIGNED_SHORT UNSIGNED_SHORT}</td><td>{@link GL11#GL_SHORT SHORT}</td></tr><tr><td>{@link GL11#GL_UNSIGNED_INT UNSIGNED_INT}</td><td>{@link GL11#GL_INT INT}</td><td>{@link GL30#GL_HALF_FLOAT HALF_FLOAT}</td><td>{@link GL11#GL_FLOAT FLOAT}</td></tr><tr><td>{@link GL12#GL_UNSIGNED_BYTE_3_3_2 UNSIGNED_BYTE_3_3_2}</td><td>{@link GL12#GL_UNSIGNED_BYTE_2_3_3_REV UNSIGNED_BYTE_2_3_3_REV}</td><td>{@link GL12#GL_UNSIGNED_SHORT_5_6_5 UNSIGNED_SHORT_5_6_5}</td><td>{@link GL12#GL_UNSIGNED_SHORT_5_6_5_REV UNSIGNED_SHORT_5_6_5_REV}</td></tr><tr><td>{@link GL12#GL_UNSIGNED_SHORT_4_4_4_4 UNSIGNED_SHORT_4_4_4_4}</td><td>{@link GL12#GL_UNSIGNED_SHORT_4_4_4_4_REV UNSIGNED_SHORT_4_4_4_4_REV}</td><td>{@link GL12#GL_UNSIGNED_SHORT_5_5_5_1 UNSIGNED_SHORT_5_5_5_1}</td><td>{@link GL12#GL_UNSIGNED_SHORT_1_5_5_5_REV UNSIGNED_SHORT_1_5_5_5_REV}</td></tr><tr><td>{@link GL12#GL_UNSIGNED_INT_8_8_8_8 UNSIGNED_INT_8_8_8_8}</td><td>{@link GL12#GL_UNSIGNED_INT_8_8_8_8_REV UNSIGNED_INT_8_8_8_8_REV}</td><td>{@link GL12#GL_UNSIGNED_INT_10_10_10_2 UNSIGNED_INT_10_10_10_2}</td><td>{@link GL12#GL_UNSIGNED_INT_2_10_10_10_REV UNSIGNED_INT_2_10_10_10_REV}</td></tr><tr><td>{@link GL30#GL_UNSIGNED_INT_24_8 UNSIGNED_INT_24_8}</td><td>{@link GL30#GL_UNSIGNED_INT_10F_11F_11F_REV UNSIGNED_INT_10F_11F_11F_REV}</td><td>{@link GL30#GL_UNSIGNED_INT_5_9_9_9_REV UNSIGNED_INT_5_9_9_9_REV}</td><td>{@link GL30#GL_FLOAT_32_UNSIGNED_INT_24_8_REV FLOAT_32_UNSIGNED_INT_24_8_REV}</td></tr><tr><td>{@link GL11#GL_BITMAP BITMAP}</td></tr></table>
     * @param data           the buffer containing the data to be used as the source of the constant fill value. The elements of data are converted by the GL into the format
     *                       specified by internalFormat, and then used to fill the specified range of the destination buffer. If data is {@code NULL}, then it is ignored and the
     *                       sub-range of the buffer is filled with zeros.
     *
     * @see <a target="_blank" href="http://docs.gl/gl4/glClearBufferSubData">Reference Page</a>
     */
    fun clearBufferSubData(target: BufferTarget, internalFormat: InternalFormat, offset: Int, size: Int, format: gl.ExternalFormat, type: gl.TypeFormat, data: Buffer? = null) =
        GL43C.nglClearBufferSubData(target.i, internalFormat.i, offset.L, size.L, format.i, type.i, data?.adr ?: NULL)

    // --- [ glDispatchCompute ] ---

    /**
     * Launches one or more compute work groups.
     *
     * @param numGroupsX the number of work groups to be launched in the X dimension
     * @param numGroupsY the number of work groups to be launched in the Y dimension
     * @param numGroupsZ the number of work groups to be launched in the Z dimension
     *
     * @see <a target="_blank" href="http://docs.gl/gl4/glDispatchCompute">Reference Page</a>
     */
    fun dispatchCompute(numGroupsX: Int, numGroupsY: Int, numGroupsZ: Int) = GL43C.glDispatchCompute(numGroupsX, numGroupsY, numGroupsZ)

    /**
     * Launches one or more compute work groups.
     *
     * @param numGroups     the number of work groups to be launched in the 3 dimensions
     *
     * @see <a target="_blank" href="http://docs.gl/gl4/glDispatchCompute">Reference Page</a>
     */
    fun dispatchCompute(numGroups: Vec3i) = GL43C.glDispatchCompute(numGroups.x, numGroups.y, numGroups.z)

    // --- [ glDispatchComputeIndirect ] ---

    /**
     * Launches one or more compute work groups using parameters stored in a buffer.
     *
     * <p>The parameters addressed by indirect are packed a structure, which takes the form (in C):</p>
     *
     * <pre><code>
     * typedef struct {
     *     uint num_groups_x;
     *     uint num_groups_y;
     *     uint num_groups_z;
     * } DispatchIndirectCommand;</code></pre>
     *
     * <p>A call to {@code glDispatchComputeIndirect} is equivalent, assuming no errors are generated, to:</p>
     *
     * <pre><code>
     * cmd = (const DispatchIndirectCommand *)indirect;
     * glDispatchCompute(cmd-&gt;num_groups_x, cmd-&gt;num_groups_y, cmd-&gt;num_groups_z);</code></pre>
     *
     * @param indirect the offset into the buffer object currently bound to the {@link #GL_DISPATCH_INDIRECT_BUFFER DISPATCH_INDIRECT_BUFFER} buffer target at which the dispatch parameters are
     *                 stored.
     *
     * @see <a target="_blank" href="http://docs.gl/gl4/glDispatchComputeIndirect">Reference Page</a>
     */
    fun dispatchComputeIndirect(indirect: Ptr) = GL43C.glDispatchComputeIndirect(indirect)

    // --- [ glCopyImageSubData ] ---

    /**
     * Performs a raw data copy between two images.
     *
     * @param srcName   the name of a texture or renderbuffer object from which to copy
     * @param srcTarget the target representing the namespace of the source name {@code srcName}
     * @param srcLevel  the mipmap level to read from the source
     * @param srcX      the X coordinate of the left edge of the souce region to copy
     * @param srcY      the Y coordinate of the top edge of the souce region to copy
     * @param srcZ      the Z coordinate of the near edge of the souce region to copy
     * @param dstName   the name of a texture or renderbuffer object to which to copy
     * @param dstTarget the target representing the namespace of the destination name {@code dstName}
     * @param dstLevel  the mipmap level to write to the source
     * @param dstX      the X coordinate of the left edge of the destination region
     * @param dstY      the Y coordinate of the top edge of the destination region
     * @param dstZ      the Z coordinate of the near edge of the destination region
     * @param srcWidth  the width of the region to be copied
     * @param srcHeight the height of the region to be copied
     * @param srcDepth  the depth of the region to be copied
     *
     * @see <a target="_blank" href="http://docs.gl/gl4/glCopyImageSubData">Reference Page</a>
     */
//    fun copyImageSubData(srcName: GlTexture, @NativeType("GLenum") int srcTarget, @NativeType("GLint") int srcLevel, @NativeType("GLint") int srcX, @NativeType("GLint") int srcY, @NativeType("GLint") int srcZ, @NativeType("GLuint") int dstName, @NativeType("GLenum") int dstTarget, @NativeType("GLint") int dstLevel, @NativeType("GLint") int dstX, @NativeType("GLint") int dstY, @NativeType("GLint") int dstZ, @NativeType("GLsizei") int srcWidth, @NativeType("GLsizei") int srcHeight, @NativeType("GLsizei") int srcDepth);

//    // --- [ glDebugMessageControl ] ---
//
//    /**
//     * Unsafe version of: {@link #glDebugMessageControl DebugMessageControl}
//     *
//     * @param count the length of the array {@code ids}
//     */
//    public static native void nglDebugMessageControl(int source, int type, int severity, int count, long ids, boolean enabled);
//
//    /**
//     * Controls the volume of debug output in the active debug group, by disabling specific or groups of messages.
//     *
//     * <p>If {@code enabled} is {@link GL11#GL_TRUE TRUE}, the referenced subset of messages will be enabled. If {@link GL11#GL_FALSE FALSE}, then those messages will be disabled.</p>
//     *
//     * <p>This command can reference different subsets of messages by first considering the set of all messages, and filtering out messages based on the following
//     * ways:</p>
//     *
//     * <ul>
//     * <li>If {@code source}, {@code type}, or {@code severity} is {@link GL11#GL_DONT_CARE DONT_CARE}, the messages from all sources, of all types, or of all severities are
//     * referenced respectively.</li>
//     * <li>When values other than {@link GL11#GL_DONT_CARE DONT_CARE} are specified, all messages whose source, type, or severity match the specified {@code source}, {@code type},
//     * or {@code severity} respectively will be referenced.</li>
//     * <li>If {@code count} is greater than zero, then {@code ids} is an array of {@code count} message IDs for the specified combination of {@code source} and
//     * {@code type}. In this case, if {@code source} or {@code type} is {@link GL11#GL_DONT_CARE DONT_CARE}, or {@code severity} is not {@link GL11#GL_DONT_CARE DONT_CARE}, the error
//     * {@link GL11#GL_INVALID_OPERATION INVALID_OPERATION} is generated.</li>
//     * </ul>
//     *
//     * <p>Unrecognized message IDs in {@code ids} are ignored. If {@code count} is zero, the value if {@code ids} is ignored.</p>
//     *
//     * <p>Although messages are grouped into an implicit hierarchy by their sources and types, there is no explicit per-source, per-type or per-severity enabled
//     * state. Instead, the enabled state is stored individually for each message. There is no difference between disabling all messages from one source in a
//     * single call, and individually disabling all messages from that source using their types and IDs.</p>
//     *
//     * <p>If the {@link #GL_DEBUG_OUTPUT DEBUG_OUTPUT} state is disabled the GL operates the same as if messages of every {@code source}, {@code type} or {@code severity} are disabled.</p>
//     *
//     * @param source   the source of debug messages to enable or disable. One of:<br><table><tr><td>{@link #GL_DEBUG_SOURCE_API DEBUG_SOURCE_API}</td><td>{@link #GL_DEBUG_SOURCE_WINDOW_SYSTEM DEBUG_SOURCE_WINDOW_SYSTEM}</td><td>{@link #GL_DEBUG_SOURCE_SHADER_COMPILER DEBUG_SOURCE_SHADER_COMPILER}</td></tr><tr><td>{@link #GL_DEBUG_SOURCE_THIRD_PARTY DEBUG_SOURCE_THIRD_PARTY}</td><td>{@link #GL_DEBUG_SOURCE_APPLICATION DEBUG_SOURCE_APPLICATION}</td><td>{@link #GL_DEBUG_SOURCE_OTHER DEBUG_SOURCE_OTHER}</td></tr></table>
//     * @param type     the type of debug messages to enable or disable. One of:<br><table><tr><td>{@link #GL_DEBUG_TYPE_ERROR DEBUG_TYPE_ERROR}</td><td>{@link #GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR DEBUG_TYPE_DEPRECATED_BEHAVIOR}</td><td>{@link #GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR DEBUG_TYPE_UNDEFINED_BEHAVIOR}</td></tr><tr><td>{@link #GL_DEBUG_TYPE_PORTABILITY DEBUG_TYPE_PORTABILITY}</td><td>{@link #GL_DEBUG_TYPE_PERFORMANCE DEBUG_TYPE_PERFORMANCE}</td><td>{@link #GL_DEBUG_TYPE_OTHER DEBUG_TYPE_OTHER}</td></tr><tr><td>{@link #GL_DEBUG_TYPE_MARKER DEBUG_TYPE_MARKER}</td></tr></table>
//     * @param severity the severity of debug messages to enable or disable. One of:<br><table><tr><td>{@link #GL_DEBUG_SEVERITY_HIGH DEBUG_SEVERITY_HIGH}</td><td>{@link #GL_DEBUG_SEVERITY_MEDIUM DEBUG_SEVERITY_MEDIUM}</td><td>{@link #GL_DEBUG_SEVERITY_LOW DEBUG_SEVERITY_LOW}</td></tr><tr><td>{@link #GL_DEBUG_SEVERITY_NOTIFICATION DEBUG_SEVERITY_NOTIFICATION}</td></tr></table>
//     * @param ids      an array of unsigned integers containing the ids of the messages to enable or disable
//     * @param enabled  whether the selected messages should be enabled or disabled
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glDebugMessageControl">Reference Page</a>
//     */
//    public static void glDebugMessageControl(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLenum") int severity, @Nullable @NativeType("GLuint const *") IntBuffer ids, @NativeType("GLboolean") boolean enabled) {
//        nglDebugMessageControl(source, type, severity, remainingSafe(ids), memAddressSafe(ids), enabled);
//    }
//
//    /**
//     * Controls the volume of debug output in the active debug group, by disabling specific or groups of messages.
//     *
//     * <p>If {@code enabled} is {@link GL11#GL_TRUE TRUE}, the referenced subset of messages will be enabled. If {@link GL11#GL_FALSE FALSE}, then those messages will be disabled.</p>
//     *
//     * <p>This command can reference different subsets of messages by first considering the set of all messages, and filtering out messages based on the following
//     * ways:</p>
//     *
//     * <ul>
//     * <li>If {@code source}, {@code type}, or {@code severity} is {@link GL11#GL_DONT_CARE DONT_CARE}, the messages from all sources, of all types, or of all severities are
//     * referenced respectively.</li>
//     * <li>When values other than {@link GL11#GL_DONT_CARE DONT_CARE} are specified, all messages whose source, type, or severity match the specified {@code source}, {@code type},
//     * or {@code severity} respectively will be referenced.</li>
//     * <li>If {@code count} is greater than zero, then {@code ids} is an array of {@code count} message IDs for the specified combination of {@code source} and
//     * {@code type}. In this case, if {@code source} or {@code type} is {@link GL11#GL_DONT_CARE DONT_CARE}, or {@code severity} is not {@link GL11#GL_DONT_CARE DONT_CARE}, the error
//     * {@link GL11#GL_INVALID_OPERATION INVALID_OPERATION} is generated.</li>
//     * </ul>
//     *
//     * <p>Unrecognized message IDs in {@code ids} are ignored. If {@code count} is zero, the value if {@code ids} is ignored.</p>
//     *
//     * <p>Although messages are grouped into an implicit hierarchy by their sources and types, there is no explicit per-source, per-type or per-severity enabled
//     * state. Instead, the enabled state is stored individually for each message. There is no difference between disabling all messages from one source in a
//     * single call, and individually disabling all messages from that source using their types and IDs.</p>
//     *
//     * <p>If the {@link #GL_DEBUG_OUTPUT DEBUG_OUTPUT} state is disabled the GL operates the same as if messages of every {@code source}, {@code type} or {@code severity} are disabled.</p>
//     *
//     * @param source   the source of debug messages to enable or disable. One of:<br><table><tr><td>{@link #GL_DEBUG_SOURCE_API DEBUG_SOURCE_API}</td><td>{@link #GL_DEBUG_SOURCE_WINDOW_SYSTEM DEBUG_SOURCE_WINDOW_SYSTEM}</td><td>{@link #GL_DEBUG_SOURCE_SHADER_COMPILER DEBUG_SOURCE_SHADER_COMPILER}</td></tr><tr><td>{@link #GL_DEBUG_SOURCE_THIRD_PARTY DEBUG_SOURCE_THIRD_PARTY}</td><td>{@link #GL_DEBUG_SOURCE_APPLICATION DEBUG_SOURCE_APPLICATION}</td><td>{@link #GL_DEBUG_SOURCE_OTHER DEBUG_SOURCE_OTHER}</td></tr></table>
//     * @param type     the type of debug messages to enable or disable. One of:<br><table><tr><td>{@link #GL_DEBUG_TYPE_ERROR DEBUG_TYPE_ERROR}</td><td>{@link #GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR DEBUG_TYPE_DEPRECATED_BEHAVIOR}</td><td>{@link #GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR DEBUG_TYPE_UNDEFINED_BEHAVIOR}</td></tr><tr><td>{@link #GL_DEBUG_TYPE_PORTABILITY DEBUG_TYPE_PORTABILITY}</td><td>{@link #GL_DEBUG_TYPE_PERFORMANCE DEBUG_TYPE_PERFORMANCE}</td><td>{@link #GL_DEBUG_TYPE_OTHER DEBUG_TYPE_OTHER}</td></tr><tr><td>{@link #GL_DEBUG_TYPE_MARKER DEBUG_TYPE_MARKER}</td></tr></table>
//     * @param severity the severity of debug messages to enable or disable. One of:<br><table><tr><td>{@link #GL_DEBUG_SEVERITY_HIGH DEBUG_SEVERITY_HIGH}</td><td>{@link #GL_DEBUG_SEVERITY_MEDIUM DEBUG_SEVERITY_MEDIUM}</td><td>{@link #GL_DEBUG_SEVERITY_LOW DEBUG_SEVERITY_LOW}</td></tr><tr><td>{@link #GL_DEBUG_SEVERITY_NOTIFICATION DEBUG_SEVERITY_NOTIFICATION}</td></tr></table>
//     * @param enabled  whether the selected messages should be enabled or disabled
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glDebugMessageControl">Reference Page</a>
//     */
//    public static void glDebugMessageControl(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLenum") int severity, @Nullable @NativeType("GLuint const *") int id, @NativeType("GLboolean") boolean enabled) {
//        MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
//        try {
//            IntBuffer ids = stack.ints(id);
//            nglDebugMessageControl(source, type, severity, 1, memAddress(ids), enabled);
//        } finally {
//            stack.setPointer(stackPointer);
//        }
//    }
//
//    // --- [ glDebugMessageInsert ] ---
//
//    /**
//     * Unsafe version of: {@link #glDebugMessageInsert DebugMessageInsert}
//     *
//     * @param length the length of the string contained in the character array whose address is given by {@code message}
//     */
//    public static native void nglDebugMessageInsert(int source, int type, int id, int severity, int length, long message);
//
//    /**
//     * This function can be called by applications and third-party libraries to generate their own messages, such as ones containing timestamp information or
//     * signals about specific render system events.
//     *
//     * <p>The value of {@code id} specifies the ID for the message and {@code severity} indicates its severity level as defined by the caller. The string
//     * {@code buf} contains the string representation of the message. The parameter {@code length} contains the number of characters in {@code buf}. If
//     * {@code length} is negative, it is implied that {@code buf} contains a null terminated string. The error {@link GL11#GL_INVALID_VALUE INVALID_VALUE} will be generated if the
//     * number of characters in {@code buf}, excluding the null terminator when {@code length} is negative, is not less than the value of
//     * {@link #GL_MAX_DEBUG_MESSAGE_LENGTH MAX_DEBUG_MESSAGE_LENGTH}.</p>
//     *
//     * <p>If the {@link #GL_DEBUG_OUTPUT DEBUG_OUTPUT} state is disabled calls to DebugMessageInsert are discarded and do not generate an error.</p>
//     *
//     * @param source   the source of the debug message to insert. One of:<br><table><tr><td>{@link #GL_DEBUG_SOURCE_API DEBUG_SOURCE_API}</td><td>{@link #GL_DEBUG_SOURCE_WINDOW_SYSTEM DEBUG_SOURCE_WINDOW_SYSTEM}</td><td>{@link #GL_DEBUG_SOURCE_SHADER_COMPILER DEBUG_SOURCE_SHADER_COMPILER}</td></tr><tr><td>{@link #GL_DEBUG_SOURCE_THIRD_PARTY DEBUG_SOURCE_THIRD_PARTY}</td><td>{@link #GL_DEBUG_SOURCE_APPLICATION DEBUG_SOURCE_APPLICATION}</td><td>{@link #GL_DEBUG_SOURCE_OTHER DEBUG_SOURCE_OTHER}</td></tr></table>
//     * @param type     the type of the debug message insert. One of:<br><table><tr><td>{@link #GL_DEBUG_TYPE_ERROR DEBUG_TYPE_ERROR}</td><td>{@link #GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR DEBUG_TYPE_DEPRECATED_BEHAVIOR}</td><td>{@link #GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR DEBUG_TYPE_UNDEFINED_BEHAVIOR}</td></tr><tr><td>{@link #GL_DEBUG_TYPE_PORTABILITY DEBUG_TYPE_PORTABILITY}</td><td>{@link #GL_DEBUG_TYPE_PERFORMANCE DEBUG_TYPE_PERFORMANCE}</td><td>{@link #GL_DEBUG_TYPE_OTHER DEBUG_TYPE_OTHER}</td></tr><tr><td>{@link #GL_DEBUG_TYPE_MARKER DEBUG_TYPE_MARKER}</td></tr></table>
//     * @param id       the user-supplied identifier of the message to insert. One of:<br><table><tr><td>{@link #GL_DEBUG_SEVERITY_HIGH DEBUG_SEVERITY_HIGH}</td><td>{@link #GL_DEBUG_SEVERITY_MEDIUM DEBUG_SEVERITY_MEDIUM}</td><td>{@link #GL_DEBUG_SEVERITY_LOW DEBUG_SEVERITY_LOW}</td></tr><tr><td>{@link #GL_DEBUG_SEVERITY_NOTIFICATION DEBUG_SEVERITY_NOTIFICATION}</td></tr></table>
//     * @param severity the severity of the debug messages to insert
//     * @param message  a character array containing the message to insert
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glDebugMessageInsert">Reference Page</a>
//     */
//    public static void glDebugMessageInsert(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLuint") int id, @NativeType("GLenum") int severity, @NativeType("GLchar const *") ByteBuffer message) {
//        nglDebugMessageInsert(source, type, id, severity, message.remaining(), memAddress(message));
//    }
//
//    /**
//     * This function can be called by applications and third-party libraries to generate their own messages, such as ones containing timestamp information or
//     * signals about specific render system events.
//     *
//     * <p>The value of {@code id} specifies the ID for the message and {@code severity} indicates its severity level as defined by the caller. The string
//     * {@code buf} contains the string representation of the message. The parameter {@code length} contains the number of characters in {@code buf}. If
//     * {@code length} is negative, it is implied that {@code buf} contains a null terminated string. The error {@link GL11#GL_INVALID_VALUE INVALID_VALUE} will be generated if the
//     * number of characters in {@code buf}, excluding the null terminator when {@code length} is negative, is not less than the value of
//     * {@link #GL_MAX_DEBUG_MESSAGE_LENGTH MAX_DEBUG_MESSAGE_LENGTH}.</p>
//     *
//     * <p>If the {@link #GL_DEBUG_OUTPUT DEBUG_OUTPUT} state is disabled calls to DebugMessageInsert are discarded and do not generate an error.</p>
//     *
//     * @param source   the source of the debug message to insert. One of:<br><table><tr><td>{@link #GL_DEBUG_SOURCE_API DEBUG_SOURCE_API}</td><td>{@link #GL_DEBUG_SOURCE_WINDOW_SYSTEM DEBUG_SOURCE_WINDOW_SYSTEM}</td><td>{@link #GL_DEBUG_SOURCE_SHADER_COMPILER DEBUG_SOURCE_SHADER_COMPILER}</td></tr><tr><td>{@link #GL_DEBUG_SOURCE_THIRD_PARTY DEBUG_SOURCE_THIRD_PARTY}</td><td>{@link #GL_DEBUG_SOURCE_APPLICATION DEBUG_SOURCE_APPLICATION}</td><td>{@link #GL_DEBUG_SOURCE_OTHER DEBUG_SOURCE_OTHER}</td></tr></table>
//     * @param type     the type of the debug message insert. One of:<br><table><tr><td>{@link #GL_DEBUG_TYPE_ERROR DEBUG_TYPE_ERROR}</td><td>{@link #GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR DEBUG_TYPE_DEPRECATED_BEHAVIOR}</td><td>{@link #GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR DEBUG_TYPE_UNDEFINED_BEHAVIOR}</td></tr><tr><td>{@link #GL_DEBUG_TYPE_PORTABILITY DEBUG_TYPE_PORTABILITY}</td><td>{@link #GL_DEBUG_TYPE_PERFORMANCE DEBUG_TYPE_PERFORMANCE}</td><td>{@link #GL_DEBUG_TYPE_OTHER DEBUG_TYPE_OTHER}</td></tr><tr><td>{@link #GL_DEBUG_TYPE_MARKER DEBUG_TYPE_MARKER}</td></tr></table>
//     * @param id       the user-supplied identifier of the message to insert. One of:<br><table><tr><td>{@link #GL_DEBUG_SEVERITY_HIGH DEBUG_SEVERITY_HIGH}</td><td>{@link #GL_DEBUG_SEVERITY_MEDIUM DEBUG_SEVERITY_MEDIUM}</td><td>{@link #GL_DEBUG_SEVERITY_LOW DEBUG_SEVERITY_LOW}</td></tr><tr><td>{@link #GL_DEBUG_SEVERITY_NOTIFICATION DEBUG_SEVERITY_NOTIFICATION}</td></tr></table>
//     * @param severity the severity of the debug messages to insert
//     * @param message  a character array containing the message to insert
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glDebugMessageInsert">Reference Page</a>
//     */
//    public static void glDebugMessageInsert(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLuint") int id, @NativeType("GLenum") int severity, @NativeType("GLchar const *") CharSequence message) {
//        MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
//        try {
//            int messageEncodedLength = stack.nUTF8(message, false);
//            long messageEncoded = stack.getPointerAddress();
//            nglDebugMessageInsert(source, type, id, severity, messageEncodedLength, messageEncoded);
//        } finally {
//            stack.setPointer(stackPointer);
//        }
//    }
//
//    // --- [ glDebugMessageCallback ] ---
//
//    /** Unsafe version of: {@link #glDebugMessageCallback DebugMessageCallback} */
//    public static native void nglDebugMessageCallback(long callback, long userParam);
//
//    /**
//     * Specifies a callback to receive debugging messages from the GL.
//     *
//     * <p>The function's prototype must follow the type definition of DEBUGPROC including its platform-dependent calling convention. Anything else will result in
//     * undefined behavior. Only one debug callback can be specified for the current context, and further calls overwrite the previous callback. Specifying
//     * {@code NULL} as the value of {@code callback} clears the current callback and disables message output through callbacks. Applications can provide
//     * user-specified data through the pointer {@code userParam}. The context will store this pointer and will include it as one of the parameters in each call
//     * to the callback function.</p>
//     *
//     * <p>If the application has specified a callback function for receiving debug output, the implementation will call that function whenever any enabled message
//     * is generated.  The source, type, ID, and severity of the message are specified by the DEBUGPROC parameters {@code source}, {@code type}, {@code id}, and
//     * {@code severity}, respectively. The string representation of the message is stored in {@code message} and its length (excluding the null-terminator) is
//     * stored in {@code length}. The parameter {@code userParam} is the user-specified parameter that was given when calling DebugMessageCallback.</p>
//     *
//     * <p>Applications can query the current callback function and the current user-specified parameter by obtaining the values of {@link #GL_DEBUG_CALLBACK_FUNCTION DEBUG_CALLBACK_FUNCTION} and
//     * {@link #GL_DEBUG_CALLBACK_USER_PARAM DEBUG_CALLBACK_USER_PARAM}, respectively.</p>
//     *
//     * <p>Applications that specify a callback function must be aware of certain special conditions when executing code inside a callback when it is called by the
//     * GL, regardless of the debug source.</p>
//     *
//     * <p>The memory for {@code message} is owned and managed by the GL, and should only be considered valid for the duration of the function call.</p>
//     *
//     * <p>The behavior of calling any GL or window system function from within the callback function is undefined and may lead to program termination.</p>
//     *
//     * <p>Care must also be taken in securing debug callbacks for use with asynchronous debug output by multi-threaded GL implementations.</p>
//     *
//     * <p>If the {@link #GL_DEBUG_OUTPUT DEBUG_OUTPUT} state is disabled then the GL will not call the callback function.</p>
//     *
//     * @param callback  a callback function that will be called when a debug message is generated
//     * @param userParam a user supplied pointer that will be passed on each invocation of {@code callback}
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glDebugMessageCallback">Reference Page</a>
//     */
//    public static void glDebugMessageCallback(@Nullable @NativeType("GLDEBUGPROC") GLDebugMessageCallbackI callback, @NativeType("void const *") long userParam) {
//        nglDebugMessageCallback(memAddressSafe(callback), userParam);
//    }
//
//    // --- [ glGetDebugMessageLog ] ---
//
//    /**
//     * Unsafe version of: {@link #glGetDebugMessageLog GetDebugMessageLog}
//     *
//     * @param bufsize the size of the buffer whose address is given by {@code messageLog}
//     */
//    public static native int nglGetDebugMessageLog(int count, int bufsize, long sources, long types, long ids, long severities, long lengths, long messageLog);
//
//    /**
//     * Retrieves messages from the debug message log.
//     *
//     * <p>This function fetches a maximum of {@code count} messages from the message log, and will return the number of messages successfully fetched.</p>
//     *
//     * <p>Messages will be fetched from the log in order of oldest to newest. Those messages that were fetched will be removed from the log.</p>
//     *
//     * <p>The sources, types, severities, IDs, and string lengths of fetched messages will be stored in the application-provided arrays {@code sources},
//     * {@code types}, {@code severities}, {@code ids}, and {@code lengths}, respectively. The application is responsible for allocating enough space for each
//     * array to hold up to {@code count} elements. The string representations of all fetched messages are stored in the {@code messageLog} array. If multiple
//     * messages are fetched, their strings are concatenated into the same {@code messageLog} array and will be separated by single null terminators. The last
//     * string in the array will also be null-terminated. The maximum size of {@code messageLog}, including the space used by all null terminators, is given by
//     * {@code bufSize}. If {@code bufSize} is less than zero and {@code messageLog} is not {@code NULL}, an {@link GL11#GL_INVALID_VALUE INVALID_VALUE} error will be generated. If a message's
//     * string, including its null terminator, can not fully fit within the {@code messageLog} array's remaining space, then that message and any subsequent
//     * messages will not be fetched and will remain in the log. The string lengths stored in the array {@code lengths} include the space for the null
//     * terminator of each string.</p>
//     *
//     * <p>Any or all of the arrays {@code sources}, {@code types}, {@code ids}, {@code severities}, {@code lengths} and {@code messageLog} can also be null
//     * pointers, which causes the attributes for such arrays to be discarded when messages are fetched, however those messages will still be removed from the
//     * log. Thus to simply delete up to {@code count} messages from the message log while ignoring their attributes, the application can call the function
//     * with null pointers for all attribute arrays.</p>
//     *
//     * <p>If the context was created without the {@link #GL_CONTEXT_FLAG_DEBUG_BIT CONTEXT_FLAG_DEBUG_BIT} in the {@link GL30#GL_CONTEXT_FLAGS CONTEXT_FLAGS} state, then the GL can opt to never add messages to the
//     * message log so GetDebugMessageLog will always return zero.</p>
//     *
//     * @param count      the number of debug messages to retrieve from the log
//     * @param sources    an array of variables to receive the sources of the retrieved messages
//     * @param types      an array of variables to receive the types of the retrieved messages
//     * @param ids        an array of unsigned integers to receive the ids of the retrieved messages
//     * @param severities an array of variables to receive the severites of the retrieved messages
//     * @param lengths    an array of variables to receive the lengths of the received messages
//     * @param messageLog an array of characters that will receive the messages
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetDebugMessageLog">Reference Page</a>
//     */
//    @NativeType("GLuint")
//    public static int glGetDebugMessageLog(@NativeType("GLuint") int count, @Nullable @NativeType("GLenum *") IntBuffer sources, @Nullable @NativeType("GLenum *") IntBuffer types, @Nullable @NativeType("GLuint *") IntBuffer ids, @Nullable @NativeType("GLenum *") IntBuffer severities, @Nullable @NativeType("GLsizei *") IntBuffer lengths, @Nullable @NativeType("GLchar *") ByteBuffer messageLog) {
//        if (CHECKS) {
//            checkSafe(sources, count);
//            checkSafe(types, count);
//            checkSafe(ids, count);
//            checkSafe(severities, count);
//            checkSafe(lengths, count);
//        }
//        return nglGetDebugMessageLog(count, remainingSafe(messageLog), memAddressSafe(sources), memAddressSafe(types), memAddressSafe(ids), memAddressSafe(severities), memAddressSafe(lengths), memAddressSafe(messageLog));
//    }
//
//    // --- [ glPushDebugGroup ] ---
//
//    /**
//     * Unsafe version of: {@link #glPushDebugGroup PushDebugGroup}
//     *
//     * @param length the length of the message to be sent to the debug output stream
//     */
//    public static native void nglPushDebugGroup(int source, int id, int length, long message);
//
//    /**
//     * Pushes a debug group described by the string {@code message} into the command stream. The value of {@code id} specifies the ID of messages generated.
//     * The parameter {@code length} contains the number of characters in {@code message}. If {@code length} is negative, it is implied that {@code message}
//     * contains a null terminated string. The message has the specified {@code source} and {@code id}, {@code type} {@link #GL_DEBUG_TYPE_PUSH_GROUP DEBUG_TYPE_PUSH_GROUP}, and
//     * {@code severity} {@link #GL_DEBUG_SEVERITY_NOTIFICATION DEBUG_SEVERITY_NOTIFICATION}. The GL will put a new debug group on top of the debug group stack which inherits the control of the
//     * volume of debug output of the debug group previously residing on the top of the debug group stack. Because debug groups are strictly hierarchical, any
//     * additional control of the debug output volume will only apply within the active debug group and the debug groups pushed on top of the active debug group.
//     *
//     * <p>An {@link GL11#GL_INVALID_ENUM INVALID_ENUM} error is generated if the value of {@code source} is neither {@link #GL_DEBUG_SOURCE_APPLICATION DEBUG_SOURCE_APPLICATION} nor {@link #GL_DEBUG_SOURCE_THIRD_PARTY DEBUG_SOURCE_THIRD_PARTY}. An
//     * {@link GL11#GL_INVALID_VALUE INVALID_VALUE} error is generated if {@code length} is negative and the number of characters in {@code message}, excluding the null-terminator, is
//     * not less than the value of {@link #GL_MAX_DEBUG_MESSAGE_LENGTH MAX_DEBUG_MESSAGE_LENGTH}.</p>
//     *
//     * @param source  the source of the debug message. One of:<br><table><tr><td>{@link #GL_DEBUG_SOURCE_APPLICATION DEBUG_SOURCE_APPLICATION}</td><td>{@link #GL_DEBUG_SOURCE_THIRD_PARTY DEBUG_SOURCE_THIRD_PARTY}</td></tr></table>
//     * @param id      the identifier of the message
//     * @param message a string containing the message to be sent to the debug output stream
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glPushDebugGroup">Reference Page</a>
//     */
//    public static void glPushDebugGroup(@NativeType("GLenum") int source, @NativeType("GLuint") int id, @NativeType("GLchar const *") ByteBuffer message) {
//        nglPushDebugGroup(source, id, message.remaining(), memAddress(message));
//    }
//
//    /**
//     * Pushes a debug group described by the string {@code message} into the command stream. The value of {@code id} specifies the ID of messages generated.
//     * The parameter {@code length} contains the number of characters in {@code message}. If {@code length} is negative, it is implied that {@code message}
//     * contains a null terminated string. The message has the specified {@code source} and {@code id}, {@code type} {@link #GL_DEBUG_TYPE_PUSH_GROUP DEBUG_TYPE_PUSH_GROUP}, and
//     * {@code severity} {@link #GL_DEBUG_SEVERITY_NOTIFICATION DEBUG_SEVERITY_NOTIFICATION}. The GL will put a new debug group on top of the debug group stack which inherits the control of the
//     * volume of debug output of the debug group previously residing on the top of the debug group stack. Because debug groups are strictly hierarchical, any
//     * additional control of the debug output volume will only apply within the active debug group and the debug groups pushed on top of the active debug group.
//     *
//     * <p>An {@link GL11#GL_INVALID_ENUM INVALID_ENUM} error is generated if the value of {@code source} is neither {@link #GL_DEBUG_SOURCE_APPLICATION DEBUG_SOURCE_APPLICATION} nor {@link #GL_DEBUG_SOURCE_THIRD_PARTY DEBUG_SOURCE_THIRD_PARTY}. An
//     * {@link GL11#GL_INVALID_VALUE INVALID_VALUE} error is generated if {@code length} is negative and the number of characters in {@code message}, excluding the null-terminator, is
//     * not less than the value of {@link #GL_MAX_DEBUG_MESSAGE_LENGTH MAX_DEBUG_MESSAGE_LENGTH}.</p>
//     *
//     * @param source  the source of the debug message. One of:<br><table><tr><td>{@link #GL_DEBUG_SOURCE_APPLICATION DEBUG_SOURCE_APPLICATION}</td><td>{@link #GL_DEBUG_SOURCE_THIRD_PARTY DEBUG_SOURCE_THIRD_PARTY}</td></tr></table>
//     * @param id      the identifier of the message
//     * @param message a string containing the message to be sent to the debug output stream
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glPushDebugGroup">Reference Page</a>
//     */
//    public static void glPushDebugGroup(@NativeType("GLenum") int source, @NativeType("GLuint") int id, @NativeType("GLchar const *") CharSequence message) {
//        MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
//        try {
//            int messageEncodedLength = stack.nUTF8(message, false);
//            long messageEncoded = stack.getPointerAddress();
//            nglPushDebugGroup(source, id, messageEncodedLength, messageEncoded);
//        } finally {
//            stack.setPointer(stackPointer);
//        }
//    }
//
//    // --- [ glPopDebugGroup ] ---
//
//    /**
//     * Pops the active debug group. When a debug group is popped, the GL will also generate a debug output message describing its cause based on the
//     * {@code message} string, the source {@code source}, and an ID {@code id} submitted to the associated {@link #glPushDebugGroup PushDebugGroup} command. {@link #GL_DEBUG_TYPE_PUSH_GROUP DEBUG_TYPE_PUSH_GROUP}
//     * and {@link #GL_DEBUG_TYPE_POP_GROUP DEBUG_TYPE_POP_GROUP} share a single namespace for message {@code id}. {@code severity} has the value {@link #GL_DEBUG_SEVERITY_NOTIFICATION DEBUG_SEVERITY_NOTIFICATION}. The {@code type}
//     * has the value {@link #GL_DEBUG_TYPE_POP_GROUP DEBUG_TYPE_POP_GROUP}. Popping a debug group restores the debug output volume control of the parent debug group.
//     *
//     * <p>Attempting to pop the default debug group off the stack generates a {@link GL11#GL_STACK_UNDERFLOW STACK_UNDERFLOW} error; pushing a debug group onto a stack containing
//     * {@link #GL_MAX_DEBUG_GROUP_STACK_DEPTH MAX_DEBUG_GROUP_STACK_DEPTH} minus one elements will generate a {@link GL11#GL_STACK_OVERFLOW STACK_OVERFLOW} error.</p>
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glPopDebugGroup">Reference Page</a>
//     */
//    public static native void glPopDebugGroup();
//
//    // --- [ glObjectLabel ] ---
//
//    /**
//     * Unsafe version of: {@link #glObjectLabel ObjectLabel}
//     *
//     * @param length the length of the label to be used for the object
//     */
//    public static native void nglObjectLabel(int identifier, int name, int length, long label);
//
//    /**
//     * Labels a named object identified within a namespace.
//     *
//     * @param identifier the namespace from which the name of the object is allocated. One of:<br><table><tr><td>{@link #GL_BUFFER BUFFER}</td><td>{@link #GL_SHADER SHADER}</td><td>{@link #GL_PROGRAM PROGRAM}</td><td>{@link #GL_QUERY QUERY}</td><td>{@link #GL_PROGRAM_PIPELINE PROGRAM_PIPELINE}</td><td>{@link #GL_SAMPLER SAMPLER}</td><td>{@link GL11#GL_VERTEX_ARRAY VERTEX_ARRAY}</td><td>{@link GL11#GL_TEXTURE TEXTURE}</td></tr><tr><td>{@link GL30#GL_RENDERBUFFER RENDERBUFFER}</td><td>{@link GL30#GL_FRAMEBUFFER FRAMEBUFFER}</td><td>{@link GL40#GL_TRANSFORM_FEEDBACK TRANSFORM_FEEDBACK}</td></tr></table>
//     * @param name       the name of the object to label
//     * @param label      a string containing the label to assign to the object
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glObjectLabel">Reference Page</a>
//     */
//    public static void glObjectLabel(@NativeType("GLenum") int identifier, @NativeType("GLuint") int name, @NativeType("GLchar const *") ByteBuffer label) {
//        nglObjectLabel(identifier, name, label.remaining(), memAddress(label));
//    }
//
//    /**
//     * Labels a named object identified within a namespace.
//     *
//     * @param identifier the namespace from which the name of the object is allocated. One of:<br><table><tr><td>{@link #GL_BUFFER BUFFER}</td><td>{@link #GL_SHADER SHADER}</td><td>{@link #GL_PROGRAM PROGRAM}</td><td>{@link #GL_QUERY QUERY}</td><td>{@link #GL_PROGRAM_PIPELINE PROGRAM_PIPELINE}</td><td>{@link #GL_SAMPLER SAMPLER}</td><td>{@link GL11#GL_VERTEX_ARRAY VERTEX_ARRAY}</td><td>{@link GL11#GL_TEXTURE TEXTURE}</td></tr><tr><td>{@link GL30#GL_RENDERBUFFER RENDERBUFFER}</td><td>{@link GL30#GL_FRAMEBUFFER FRAMEBUFFER}</td><td>{@link GL40#GL_TRANSFORM_FEEDBACK TRANSFORM_FEEDBACK}</td></tr></table>
//     * @param name       the name of the object to label
//     * @param label      a string containing the label to assign to the object
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glObjectLabel">Reference Page</a>
//     */
//    public static void glObjectLabel(@NativeType("GLenum") int identifier, @NativeType("GLuint") int name, @NativeType("GLchar const *") CharSequence label) {
//        MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
//        try {
//            int labelEncodedLength = stack.nUTF8(label, false);
//            long labelEncoded = stack.getPointerAddress();
//            nglObjectLabel(identifier, name, labelEncodedLength, labelEncoded);
//        } finally {
//            stack.setPointer(stackPointer);
//        }
//    }
//
//    // --- [ glGetObjectLabel ] ---
//
//    /**
//     * Unsafe version of: {@link #glGetObjectLabel GetObjectLabel}
//     *
//     * @param bufSize the length of the buffer whose address is in {@code label}
//     */
//    public static native void nglGetObjectLabel(int identifier, int name, int bufSize, long length, long label);
//
//    /**
//     * Retrieves the label of a named object identified within a namespace.
//     *
//     * @param identifier the namespace from which the name of the object is allocated. One of:<br><table><tr><td>{@link #GL_BUFFER BUFFER}</td><td>{@link #GL_SHADER SHADER}</td><td>{@link #GL_PROGRAM PROGRAM}</td><td>{@link #GL_QUERY QUERY}</td><td>{@link #GL_PROGRAM_PIPELINE PROGRAM_PIPELINE}</td><td>{@link #GL_SAMPLER SAMPLER}</td><td>{@link GL11#GL_VERTEX_ARRAY VERTEX_ARRAY}</td><td>{@link GL11#GL_TEXTURE TEXTURE}</td></tr><tr><td>{@link GL30#GL_RENDERBUFFER RENDERBUFFER}</td><td>{@link GL30#GL_FRAMEBUFFER FRAMEBUFFER}</td><td>{@link GL40#GL_TRANSFORM_FEEDBACK TRANSFORM_FEEDBACK}</td></tr></table>
//     * @param name       the name of the object whose label to retrieve
//     * @param length     the address of a variable to receive the length of the object label
//     * @param label      a string that will receive the object label
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetObjectLabel">Reference Page</a>
//     */
//    public static void glGetObjectLabel(@NativeType("GLenum") int identifier, @NativeType("GLuint") int name, @Nullable @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer label) {
//        if (CHECKS) {
//            checkSafe(length, 1);
//        }
//        nglGetObjectLabel(identifier, name, label.remaining(), memAddressSafe(length), memAddress(label));
//    }
//
//    /**
//     * Retrieves the label of a named object identified within a namespace.
//     *
//     * @param identifier the namespace from which the name of the object is allocated. One of:<br><table><tr><td>{@link #GL_BUFFER BUFFER}</td><td>{@link #GL_SHADER SHADER}</td><td>{@link #GL_PROGRAM PROGRAM}</td><td>{@link #GL_QUERY QUERY}</td><td>{@link #GL_PROGRAM_PIPELINE PROGRAM_PIPELINE}</td><td>{@link #GL_SAMPLER SAMPLER}</td><td>{@link GL11#GL_VERTEX_ARRAY VERTEX_ARRAY}</td><td>{@link GL11#GL_TEXTURE TEXTURE}</td></tr><tr><td>{@link GL30#GL_RENDERBUFFER RENDERBUFFER}</td><td>{@link GL30#GL_FRAMEBUFFER FRAMEBUFFER}</td><td>{@link GL40#GL_TRANSFORM_FEEDBACK TRANSFORM_FEEDBACK}</td></tr></table>
//     * @param name       the name of the object whose label to retrieve
//     * @param bufSize    the length of the buffer whose address is in {@code label}
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetObjectLabel">Reference Page</a>
//     */
//    @NativeType("void")
//    public static String glGetObjectLabel(@NativeType("GLenum") int identifier, @NativeType("GLuint") int name, @NativeType("GLsizei") int bufSize) {
//        MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
//        try {
//            IntBuffer length = stack.ints(0);
//            ByteBuffer label = stack.malloc(bufSize);
//            nglGetObjectLabel(identifier, name, bufSize, memAddress(length), memAddress(label));
//            return memUTF8(label, length.get(0));
//        } finally {
//            stack.setPointer(stackPointer);
//        }
//    }
//
//    /**
//     * Retrieves the label of a named object identified within a namespace.
//     *
//     * @param identifier the namespace from which the name of the object is allocated. One of:<br><table><tr><td>{@link #GL_BUFFER BUFFER}</td><td>{@link #GL_SHADER SHADER}</td><td>{@link #GL_PROGRAM PROGRAM}</td><td>{@link #GL_QUERY QUERY}</td><td>{@link #GL_PROGRAM_PIPELINE PROGRAM_PIPELINE}</td><td>{@link #GL_SAMPLER SAMPLER}</td><td>{@link GL11#GL_VERTEX_ARRAY VERTEX_ARRAY}</td><td>{@link GL11#GL_TEXTURE TEXTURE}</td></tr><tr><td>{@link GL30#GL_RENDERBUFFER RENDERBUFFER}</td><td>{@link GL30#GL_FRAMEBUFFER FRAMEBUFFER}</td><td>{@link GL40#GL_TRANSFORM_FEEDBACK TRANSFORM_FEEDBACK}</td></tr></table>
//     * @param name       the name of the object whose label to retrieve
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetObjectLabel">Reference Page</a>
//     */
//    @NativeType("void")
//    public static String glGetObjectLabel(@NativeType("GLenum") int identifier, @NativeType("GLuint") int name) {
//        return glGetObjectLabel(identifier, name, GL11.glGetInteger(GL_MAX_LABEL_LENGTH));
//    }
//
//    // --- [ glObjectPtrLabel ] ---
//
//    /**
//     * Unsafe version of: {@link #glObjectPtrLabel ObjectPtrLabel}
//     *
//     * @param length the length of the label to be used for the object
//     */
//    public static native void nglObjectPtrLabel(long ptr, int length, long label);
//
//    /**
//     * Labels a sync object identified by a pointer.
//     *
//     * @param ptr   a pointer identifying a sync object
//     * @param label a string containing the label to assign to the object
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glObjectPtrLabel">Reference Page</a>
//     */
//    public static void glObjectPtrLabel(@NativeType("void *") long ptr, @NativeType("GLchar const *") ByteBuffer label) {
//        if (CHECKS) {
//            check(ptr);
//        }
//        nglObjectPtrLabel(ptr, label.remaining(), memAddress(label));
//    }
//
//    /**
//     * Labels a sync object identified by a pointer.
//     *
//     * @param ptr   a pointer identifying a sync object
//     * @param label a string containing the label to assign to the object
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glObjectPtrLabel">Reference Page</a>
//     */
//    public static void glObjectPtrLabel(@NativeType("void *") long ptr, @NativeType("GLchar const *") CharSequence label) {
//        if (CHECKS) {
//            check(ptr);
//        }
//        MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
//        try {
//            int labelEncodedLength = stack.nUTF8(label, false);
//            long labelEncoded = stack.getPointerAddress();
//            nglObjectPtrLabel(ptr, labelEncodedLength, labelEncoded);
//        } finally {
//            stack.setPointer(stackPointer);
//        }
//    }
//
//    // --- [ glGetObjectPtrLabel ] ---
//
//    /**
//     * Unsafe version of: {@link #glGetObjectPtrLabel GetObjectPtrLabel}
//     *
//     * @param bufSize the length of the buffer whose address is in {@code label}
//     */
//    public static native void nglGetObjectPtrLabel(long ptr, int bufSize, long length, long label);
//
//    /**
//     * Retrieves the label of a sync object identified by a pointer.
//     *
//     * @param ptr    the name of the sync object whose label to retrieve
//     * @param length a variable to receive the length of the object label
//     * @param label  a string that will receive the object label
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetObjectPtrLabel">Reference Page</a>
//     */
//    public static void glGetObjectPtrLabel(@NativeType("void *") long ptr, @Nullable @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer label) {
//        if (CHECKS) {
//            check(ptr);
//            checkSafe(length, 1);
//        }
//        nglGetObjectPtrLabel(ptr, label.remaining(), memAddressSafe(length), memAddress(label));
//    }
//
//    /**
//     * Retrieves the label of a sync object identified by a pointer.
//     *
//     * @param ptr     the name of the sync object whose label to retrieve
//     * @param bufSize the length of the buffer whose address is in {@code label}
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetObjectPtrLabel">Reference Page</a>
//     */
//    @NativeType("void")
//    public static String glGetObjectPtrLabel(@NativeType("void *") long ptr, @NativeType("GLsizei") int bufSize) {
//        if (CHECKS) {
//            check(ptr);
//        }
//        MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
//        try {
//            IntBuffer length = stack.ints(0);
//            ByteBuffer label = stack.malloc(bufSize);
//            nglGetObjectPtrLabel(ptr, bufSize, memAddress(length), memAddress(label));
//            return memUTF8(label, length.get(0));
//        } finally {
//            stack.setPointer(stackPointer);
//        }
//    }
//
//    /**
//     * Retrieves the label of a sync object identified by a pointer.
//     *
//     * @param ptr the name of the sync object whose label to retrieve
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetObjectPtrLabel">Reference Page</a>
//     */
//    @NativeType("void")
//    public static String glGetObjectPtrLabel(@NativeType("void *") long ptr) {
//        return glGetObjectPtrLabel(ptr, GL11.glGetInteger(GL_MAX_LABEL_LENGTH));
//    }
//
//    // --- [ glFramebufferParameteri ] ---
//
//    /**
//     * Sets a named parameter of a framebuffer.
//     *
//     * @param target target of the operation. One of:<br><table><tr><td>{@link GL30#GL_READ_FRAMEBUFFER READ_FRAMEBUFFER}</td><td>{@link GL30#GL_DRAW_FRAMEBUFFER DRAW_FRAMEBUFFER}</td><td>{@link GL30#GL_FRAMEBUFFER FRAMEBUFFER}</td></tr></table>
//     * @param pname  a token indicating the parameter to be modified. One of:<br><table><tr><td>{@link #GL_FRAMEBUFFER_DEFAULT_WIDTH FRAMEBUFFER_DEFAULT_WIDTH}</td><td>{@link #GL_FRAMEBUFFER_DEFAULT_HEIGHT FRAMEBUFFER_DEFAULT_HEIGHT}</td></tr><tr><td>{@link #GL_FRAMEBUFFER_DEFAULT_LAYERS FRAMEBUFFER_DEFAULT_LAYERS}</td><td>{@link #GL_FRAMEBUFFER_DEFAULT_SAMPLES FRAMEBUFFER_DEFAULT_SAMPLES}</td></tr><tr><td>{@link #GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS}</td></tr></table>
//     * @param param  the new value for the parameter named {@code pname}
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glFramebufferParameteri">Reference Page</a>
//     */
//    public static native void glFramebufferParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint") int param);
//
//    // --- [ glGetFramebufferParameteriv ] ---
//
//    /** Unsafe version of: {@link #glGetFramebufferParameteriv GetFramebufferParameteriv} */
//    public static native void nglGetFramebufferParameteriv(int target, int pname, long params);
//
//    /**
//     * Retrieves a named parameter from a framebuffer.
//     *
//     * @param target target of the operation. One of:<br><table><tr><td>{@link GL30#GL_READ_FRAMEBUFFER READ_FRAMEBUFFER}</td><td>{@link GL30#GL_DRAW_FRAMEBUFFER DRAW_FRAMEBUFFER}</td><td>{@link GL30#GL_FRAMEBUFFER FRAMEBUFFER}</td></tr></table>
//     * @param pname  a token indicating the parameter to be retrieved. One of:<br><table><tr><td>{@link #GL_FRAMEBUFFER_DEFAULT_WIDTH FRAMEBUFFER_DEFAULT_WIDTH}</td><td>{@link #GL_FRAMEBUFFER_DEFAULT_HEIGHT FRAMEBUFFER_DEFAULT_HEIGHT}</td></tr><tr><td>{@link #GL_FRAMEBUFFER_DEFAULT_LAYERS FRAMEBUFFER_DEFAULT_LAYERS}</td><td>{@link #GL_FRAMEBUFFER_DEFAULT_SAMPLES FRAMEBUFFER_DEFAULT_SAMPLES}</td></tr><tr><td>{@link #GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS}</td></tr></table>
//     * @param params a variable to receive the value of the parameter named {@code pname}
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetFramebufferParameter">Reference Page</a>
//     */
//    public static void glGetFramebufferParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
//        if (CHECKS) {
//            check(params, 1);
//        }
//        nglGetFramebufferParameteriv(target, pname, memAddress(params));
//    }
//
//    /**
//     * Retrieves a named parameter from a framebuffer.
//     *
//     * @param target target of the operation. One of:<br><table><tr><td>{@link GL30#GL_READ_FRAMEBUFFER READ_FRAMEBUFFER}</td><td>{@link GL30#GL_DRAW_FRAMEBUFFER DRAW_FRAMEBUFFER}</td><td>{@link GL30#GL_FRAMEBUFFER FRAMEBUFFER}</td></tr></table>
//     * @param pname  a token indicating the parameter to be retrieved. One of:<br><table><tr><td>{@link #GL_FRAMEBUFFER_DEFAULT_WIDTH FRAMEBUFFER_DEFAULT_WIDTH}</td><td>{@link #GL_FRAMEBUFFER_DEFAULT_HEIGHT FRAMEBUFFER_DEFAULT_HEIGHT}</td></tr><tr><td>{@link #GL_FRAMEBUFFER_DEFAULT_LAYERS FRAMEBUFFER_DEFAULT_LAYERS}</td><td>{@link #GL_FRAMEBUFFER_DEFAULT_SAMPLES FRAMEBUFFER_DEFAULT_SAMPLES}</td></tr><tr><td>{@link #GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS}</td></tr></table>
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetFramebufferParameter">Reference Page</a>
//     */
//    @NativeType("void")
//    public static int glGetFramebufferParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
//        MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
//        try {
//            IntBuffer params = stack.callocInt(1);
//            nglGetFramebufferParameteriv(target, pname, memAddress(params));
//            return params.get(0);
//        } finally {
//            stack.setPointer(stackPointer);
//        }
//    }
//
//    // --- [ glGetInternalformati64v ] ---
//
//    /**
//     * Unsafe version of: {@link #glGetInternalformati64v GetInternalformati64v}
//     *
//     * @param bufSize the maximum number of values that may be written to params by the function
//     */
//    public static native void nglGetInternalformati64v(int target, int internalformat, int pname, int bufSize, long params);
//
//    /**
//     * Retrieves information about implementation-dependent support for internal formats.
//     *
//     * @param target         the usage of the internal format. One of:<br><table><tr><td>{@link GL11#GL_TEXTURE_1D TEXTURE_1D}</td><td>{@link GL11#GL_TEXTURE_2D TEXTURE_2D}</td><td>{@link GL30#GL_TEXTURE_1D_ARRAY TEXTURE_1D_ARRAY}</td><td>{@link GL31#GL_TEXTURE_RECTANGLE TEXTURE_RECTANGLE}</td><td>{@link GL13#GL_TEXTURE_CUBE_MAP TEXTURE_CUBE_MAP}</td></tr><tr><td>{@link GL12#GL_TEXTURE_3D TEXTURE_3D}</td><td>{@link GL30#GL_TEXTURE_2D_ARRAY TEXTURE_2D_ARRAY}</td><td>{@link GL40#GL_TEXTURE_CUBE_MAP_ARRAY TEXTURE_CUBE_MAP_ARRAY}</td><td>{@link GL30#GL_RENDERBUFFER RENDERBUFFER}</td><td>{@link GL31#GL_TEXTURE_BUFFER TEXTURE_BUFFER}</td></tr><tr><td>{@link GL32#GL_TEXTURE_2D_MULTISAMPLE TEXTURE_2D_MULTISAMPLE}</td><td>{@link GL32#GL_TEXTURE_2D_MULTISAMPLE_ARRAY TEXTURE_2D_MULTISAMPLE_ARRAY}</td></tr></table>
//     * @param internalformat the internal format about which to retrieve information
//     * @param pname          the type of information to query
//     * @param params         a variable into which to write the retrieved information
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetInternalformat">Reference Page</a>
//     */
//    public static void glGetInternalformati64v(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int pname, @NativeType("GLint64 *") LongBuffer params) {
//        nglGetInternalformati64v(target, internalformat, pname, params.remaining(), memAddress(params));
//    }
//
//    /**
//     * Retrieves information about implementation-dependent support for internal formats.
//     *
//     * @param target         the usage of the internal format. One of:<br><table><tr><td>{@link GL11#GL_TEXTURE_1D TEXTURE_1D}</td><td>{@link GL11#GL_TEXTURE_2D TEXTURE_2D}</td><td>{@link GL30#GL_TEXTURE_1D_ARRAY TEXTURE_1D_ARRAY}</td><td>{@link GL31#GL_TEXTURE_RECTANGLE TEXTURE_RECTANGLE}</td><td>{@link GL13#GL_TEXTURE_CUBE_MAP TEXTURE_CUBE_MAP}</td></tr><tr><td>{@link GL12#GL_TEXTURE_3D TEXTURE_3D}</td><td>{@link GL30#GL_TEXTURE_2D_ARRAY TEXTURE_2D_ARRAY}</td><td>{@link GL40#GL_TEXTURE_CUBE_MAP_ARRAY TEXTURE_CUBE_MAP_ARRAY}</td><td>{@link GL30#GL_RENDERBUFFER RENDERBUFFER}</td><td>{@link GL31#GL_TEXTURE_BUFFER TEXTURE_BUFFER}</td></tr><tr><td>{@link GL32#GL_TEXTURE_2D_MULTISAMPLE TEXTURE_2D_MULTISAMPLE}</td><td>{@link GL32#GL_TEXTURE_2D_MULTISAMPLE_ARRAY TEXTURE_2D_MULTISAMPLE_ARRAY}</td></tr></table>
//     * @param internalformat the internal format about which to retrieve information
//     * @param pname          the type of information to query
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetInternalformat">Reference Page</a>
//     */
//    @NativeType("void")
//    public static long glGetInternalformati64(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int pname) {
//        MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
//        try {
//            LongBuffer params = stack.callocLong(1);
//            nglGetInternalformati64v(target, internalformat, pname, 1, memAddress(params));
//            return params.get(0);
//        } finally {
//            stack.setPointer(stackPointer);
//        }
//    }
//
//    // --- [ glInvalidateTexSubImage ] ---
//
//    /**
//     * Invalidates a region of a texture image.
//     *
//     * @param texture the name of a texture object a subregion of which to invalidate
//     * @param level   the level of detail of the texture object within which the region resides
//     * @param xoffset the X offset of the region to be invalidated
//     * @param yoffset the Y offset of the region to be invalidated
//     * @param zoffset the Z offset of the region to be invalidated
//     * @param width   the width of the region to be invalidated
//     * @param height  the height of the region to be invalidated
//     * @param depth   the depth of the region to be invalidated
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glInvalidateTexSubImage">Reference Page</a>
//     */
//    public static native void glInvalidateTexSubImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int xoffset, @NativeType("GLint") int yoffset, @NativeType("GLint") int zoffset, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth);
//
//    // --- [ glInvalidateTexImage ] ---
//
//    /**
//     * Invalidates the entirety of a texture image.
//     *
//     * @param texture the name of a texture object to invalidate
//     * @param level   the level of detail of the texture object to invalidate
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glInvalidateTexImage">Reference Page</a>
//     */
//    public static native void glInvalidateTexImage(@NativeType("GLuint") int texture, @NativeType("GLint") int level);
//
//    // --- [ glInvalidateBufferSubData ] ---
//
//    /**
//     * Invalidates a region of a buffer object's data store.
//     *
//     * @param buffer the name of a buffer object, a subrange of whose data store to invalidate
//     * @param offset the offset within the buffer's data store of the start of the range to be invalidated
//     * @param length the length of the range within the buffer's data store to be invalidated
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glInvalidateBufferSubData">Reference Page</a>
//     */
//    public static native void glInvalidateBufferSubData(@NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long length);
//
//    // --- [ glInvalidateBufferData ] ---
//
//    /**
//     * Invalidates the content of a buffer object's data store.
//     *
//     * @param buffer the name of a buffer object whose data store to invalidate
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glInvalidateBufferData">Reference Page</a>
//     */
//    public static native void glInvalidateBufferData(@NativeType("GLuint") int buffer);
//
//    // --- [ glInvalidateFramebuffer ] ---
//
//    /**
//     * Unsafe version of: {@link #glInvalidateFramebuffer InvalidateFramebuffer}
//     *
//     * @param numAttachments the number of entries in the {@code attachments} array
//     */
//    public static native void nglInvalidateFramebuffer(int target, int numAttachments, long attachments);
//
//    /**
//     * Invalidate the content some or all of a framebuffer object's attachments.
//     *
//     * @param target      the target to which the framebuffer is attached. One of:<br><table><tr><td>{@link GL30#GL_FRAMEBUFFER FRAMEBUFFER}</td><td>{@link GL30#GL_DRAW_FRAMEBUFFER DRAW_FRAMEBUFFER}</td><td>{@link GL30#GL_READ_FRAMEBUFFER READ_FRAMEBUFFER}</td></tr></table>
//     * @param attachments the address of an array identifying the attachments to be invalidated
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glInvalidateFramebuffer">Reference Page</a>
//     */
//    public static void glInvalidateFramebuffer(@NativeType("GLenum") int target, @NativeType("GLenum const *") IntBuffer attachments) {
//        nglInvalidateFramebuffer(target, attachments.remaining(), memAddress(attachments));
//    }
//
//    /**
//     * Invalidate the content some or all of a framebuffer object's attachments.
//     *
//     * @param target the target to which the framebuffer is attached. One of:<br><table><tr><td>{@link GL30#GL_FRAMEBUFFER FRAMEBUFFER}</td><td>{@link GL30#GL_DRAW_FRAMEBUFFER DRAW_FRAMEBUFFER}</td><td>{@link GL30#GL_READ_FRAMEBUFFER READ_FRAMEBUFFER}</td></tr></table>
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glInvalidateFramebuffer">Reference Page</a>
//     */
//    public static void glInvalidateFramebuffer(@NativeType("GLenum") int target, @NativeType("GLenum const *") int attachment) {
//        MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
//        try {
//            IntBuffer attachments = stack.ints(attachment);
//            nglInvalidateFramebuffer(target, 1, memAddress(attachments));
//        } finally {
//            stack.setPointer(stackPointer);
//        }
//    }
//
//    // --- [ glInvalidateSubFramebuffer ] ---
//
//    /**
//     * Unsafe version of: {@link #glInvalidateSubFramebuffer InvalidateSubFramebuffer}
//     *
//     * @param numAttachments the number of entries in the {@code attachments} array
//     */
//    public static native void nglInvalidateSubFramebuffer(int target, int numAttachments, long attachments, int x, int y, int width, int height);
//
//    /**
//     * Invalidates the content of a region of some or all of a framebuffer object's attachments.
//     *
//     * @param target      the target to which the framebuffer is attached. One of:<br><table><tr><td>{@link GL30#GL_FRAMEBUFFER FRAMEBUFFER}</td><td>{@link GL30#GL_DRAW_FRAMEBUFFER DRAW_FRAMEBUFFER}</td><td>{@link GL30#GL_READ_FRAMEBUFFER READ_FRAMEBUFFER}</td></tr></table>
//     * @param attachments an array identifying the attachments to be invalidated
//     * @param x           the X offset of the region to be invalidated
//     * @param y           the Y offset of the region to be invalidated
//     * @param width       the width of the region to be invalidated
//     * @param height      the height of the region to be invalidated
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glInvalidateSubFramebuffer">Reference Page</a>
//     */
//    public static void glInvalidateSubFramebuffer(@NativeType("GLenum") int target, @NativeType("GLenum const *") IntBuffer attachments, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
//        nglInvalidateSubFramebuffer(target, attachments.remaining(), memAddress(attachments), x, y, width, height);
//    }
//
//    /**
//     * Invalidates the content of a region of some or all of a framebuffer object's attachments.
//     *
//     * @param target the target to which the framebuffer is attached. One of:<br><table><tr><td>{@link GL30#GL_FRAMEBUFFER FRAMEBUFFER}</td><td>{@link GL30#GL_DRAW_FRAMEBUFFER DRAW_FRAMEBUFFER}</td><td>{@link GL30#GL_READ_FRAMEBUFFER READ_FRAMEBUFFER}</td></tr></table>
//     * @param x      the X offset of the region to be invalidated
//     * @param y      the Y offset of the region to be invalidated
//     * @param width  the width of the region to be invalidated
//     * @param height the height of the region to be invalidated
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glInvalidateSubFramebuffer">Reference Page</a>
//     */
//    public static void glInvalidateSubFramebuffer(@NativeType("GLenum") int target, @NativeType("GLenum const *") int attachment, @NativeType("GLint") int x, @NativeType("GLint") int y, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
//        MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
//        try {
//            IntBuffer attachments = stack.ints(attachment);
//            nglInvalidateSubFramebuffer(target, 1, memAddress(attachments), x, y, width, height);
//        } finally {
//            stack.setPointer(stackPointer);
//        }
//    }
//
//    // --- [ glMultiDrawArraysIndirect ] ---
//
//    /** Unsafe version of: {@link #glMultiDrawArraysIndirect MultiDrawArraysIndirect} */
//    public static native void nglMultiDrawArraysIndirect(int mode, long indirect, int primcount, int stride);
//
//    /**
//     * Renders multiple sets of primitives from array data, taking parameters from memory.
//     *
//     * <p>The parameters addressed by {@code indirect} are packed into an array of structures, each element of which takes the form (in C):</p>
//     *
//     * <pre><code>
//     * typedef struct {
//     *     uint count;
//     *     uint primCount;
//     *     uint first;
//     *     uint baseInstance;
//     * } DrawArraysIndirectCommand;</code></pre>
//     *
//     * <p>A single call to {@code glMultiDrawArraysIndirect} is equivalent, assuming no errors are generated to:</p>
//     *
//     * <pre><code>
//     * const ubyte *ptr = (const ubyte *)indirect;
//     * for ( i = 0; i &lt; primcount; i++ ) {
//     *     DrawArraysIndirect(mode, (DrawArraysIndirectCommand*)ptr);
//     *     if ( stride == 0 )
//     *         ptr += sizeof(DrawArraysIndirectCommand);
//     *     else
//     *         ptr += stride;
//     * }</code></pre>
//     *
//     * @param mode      what kind of primitives to render. One of:<br><table><tr><td>{@link GL11#GL_POINTS POINTS}</td><td>{@link GL11#GL_LINE_STRIP LINE_STRIP}</td><td>{@link GL11#GL_LINE_LOOP LINE_LOOP}</td><td>{@link GL11#GL_LINES LINES}</td><td>{@link GL11#GL_TRIANGLE_STRIP TRIANGLE_STRIP}</td><td>{@link GL11#GL_TRIANGLE_FAN TRIANGLE_FAN}</td><td>{@link GL11#GL_TRIANGLES TRIANGLES}</td></tr><tr><td>{@link GL32#GL_LINES_ADJACENCY LINES_ADJACENCY}</td><td>{@link GL32#GL_LINE_STRIP_ADJACENCY LINE_STRIP_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLES_ADJACENCY TRIANGLES_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLE_STRIP_ADJACENCY TRIANGLE_STRIP_ADJACENCY}</td><td>{@link GL40#GL_PATCHES PATCHES}</td><td>{@link GL11#GL_POLYGON POLYGON}</td><td>{@link GL11#GL_QUADS QUADS}</td></tr><tr><td>{@link GL11#GL_QUAD_STRIP QUAD_STRIP}</td></tr></table>
//     * @param indirect  an array of structures containing the draw parameters
//     * @param primcount the number of elements in the array of draw parameter structures
//     * @param stride    the distance in basic machine units between elements of the draw parameter array
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glMultiDrawArraysIndirect">Reference Page</a>
//     */
//    public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") ByteBuffer indirect, @NativeType("GLsizei") int primcount, @NativeType("GLsizei") int stride) {
//        if (CHECKS) {
//            check(indirect, primcount * (stride == 0 ? (4 * 4) : stride));
//        }
//        nglMultiDrawArraysIndirect(mode, memAddress(indirect), primcount, stride);
//    }
//
//    /**
//     * Renders multiple sets of primitives from array data, taking parameters from memory.
//     *
//     * <p>The parameters addressed by {@code indirect} are packed into an array of structures, each element of which takes the form (in C):</p>
//     *
//     * <pre><code>
//     * typedef struct {
//     *     uint count;
//     *     uint primCount;
//     *     uint first;
//     *     uint baseInstance;
//     * } DrawArraysIndirectCommand;</code></pre>
//     *
//     * <p>A single call to {@code glMultiDrawArraysIndirect} is equivalent, assuming no errors are generated to:</p>
//     *
//     * <pre><code>
//     * const ubyte *ptr = (const ubyte *)indirect;
//     * for ( i = 0; i &lt; primcount; i++ ) {
//     *     DrawArraysIndirect(mode, (DrawArraysIndirectCommand*)ptr);
//     *     if ( stride == 0 )
//     *         ptr += sizeof(DrawArraysIndirectCommand);
//     *     else
//     *         ptr += stride;
//     * }</code></pre>
//     *
//     * @param mode      what kind of primitives to render. One of:<br><table><tr><td>{@link GL11#GL_POINTS POINTS}</td><td>{@link GL11#GL_LINE_STRIP LINE_STRIP}</td><td>{@link GL11#GL_LINE_LOOP LINE_LOOP}</td><td>{@link GL11#GL_LINES LINES}</td><td>{@link GL11#GL_TRIANGLE_STRIP TRIANGLE_STRIP}</td><td>{@link GL11#GL_TRIANGLE_FAN TRIANGLE_FAN}</td><td>{@link GL11#GL_TRIANGLES TRIANGLES}</td></tr><tr><td>{@link GL32#GL_LINES_ADJACENCY LINES_ADJACENCY}</td><td>{@link GL32#GL_LINE_STRIP_ADJACENCY LINE_STRIP_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLES_ADJACENCY TRIANGLES_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLE_STRIP_ADJACENCY TRIANGLE_STRIP_ADJACENCY}</td><td>{@link GL40#GL_PATCHES PATCHES}</td><td>{@link GL11#GL_POLYGON POLYGON}</td><td>{@link GL11#GL_QUADS QUADS}</td></tr><tr><td>{@link GL11#GL_QUAD_STRIP QUAD_STRIP}</td></tr></table>
//     * @param indirect  an array of structures containing the draw parameters
//     * @param primcount the number of elements in the array of draw parameter structures
//     * @param stride    the distance in basic machine units between elements of the draw parameter array
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glMultiDrawArraysIndirect">Reference Page</a>
//     */
//    public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") long indirect, @NativeType("GLsizei") int primcount, @NativeType("GLsizei") int stride) {
//        nglMultiDrawArraysIndirect(mode, indirect, primcount, stride);
//    }
//
//    /**
//     * Renders multiple sets of primitives from array data, taking parameters from memory.
//     *
//     * <p>The parameters addressed by {@code indirect} are packed into an array of structures, each element of which takes the form (in C):</p>
//     *
//     * <pre><code>
//     * typedef struct {
//     *     uint count;
//     *     uint primCount;
//     *     uint first;
//     *     uint baseInstance;
//     * } DrawArraysIndirectCommand;</code></pre>
//     *
//     * <p>A single call to {@code glMultiDrawArraysIndirect} is equivalent, assuming no errors are generated to:</p>
//     *
//     * <pre><code>
//     * const ubyte *ptr = (const ubyte *)indirect;
//     * for ( i = 0; i &lt; primcount; i++ ) {
//     *     DrawArraysIndirect(mode, (DrawArraysIndirectCommand*)ptr);
//     *     if ( stride == 0 )
//     *         ptr += sizeof(DrawArraysIndirectCommand);
//     *     else
//     *         ptr += stride;
//     * }</code></pre>
//     *
//     * @param mode      what kind of primitives to render. One of:<br><table><tr><td>{@link GL11#GL_POINTS POINTS}</td><td>{@link GL11#GL_LINE_STRIP LINE_STRIP}</td><td>{@link GL11#GL_LINE_LOOP LINE_LOOP}</td><td>{@link GL11#GL_LINES LINES}</td><td>{@link GL11#GL_TRIANGLE_STRIP TRIANGLE_STRIP}</td><td>{@link GL11#GL_TRIANGLE_FAN TRIANGLE_FAN}</td><td>{@link GL11#GL_TRIANGLES TRIANGLES}</td></tr><tr><td>{@link GL32#GL_LINES_ADJACENCY LINES_ADJACENCY}</td><td>{@link GL32#GL_LINE_STRIP_ADJACENCY LINE_STRIP_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLES_ADJACENCY TRIANGLES_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLE_STRIP_ADJACENCY TRIANGLE_STRIP_ADJACENCY}</td><td>{@link GL40#GL_PATCHES PATCHES}</td><td>{@link GL11#GL_POLYGON POLYGON}</td><td>{@link GL11#GL_QUADS QUADS}</td></tr><tr><td>{@link GL11#GL_QUAD_STRIP QUAD_STRIP}</td></tr></table>
//     * @param indirect  an array of structures containing the draw parameters
//     * @param primcount the number of elements in the array of draw parameter structures
//     * @param stride    the distance in basic machine units between elements of the draw parameter array
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glMultiDrawArraysIndirect">Reference Page</a>
//     */
//    public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int mode, @NativeType("void const *") IntBuffer indirect, @NativeType("GLsizei") int primcount, @NativeType("GLsizei") int stride) {
//        if (CHECKS) {
//            check(indirect, (primcount * (stride == 0 ? (4 * 4) : stride)) >> 2);
//        }
//        nglMultiDrawArraysIndirect(mode, memAddress(indirect), primcount, stride);
//    }
//
//    // --- [ glMultiDrawElementsIndirect ] ---
//
//    /** Unsafe version of: {@link #glMultiDrawElementsIndirect MultiDrawElementsIndirect} */
//    public static native void nglMultiDrawElementsIndirect(int mode, int type, long indirect, int primcount, int stride);
//
//    /**
//     * Renders multiple indexed primitives from array data, taking parameters from memory.
//     *
//     * <p>The parameters addressed by indirect are packed into a structure that takes the form (in C):</p>
//     *
//     * <pre><code>
//     * typedef struct {
//     *     uint count;
//     *     uint primCount;
//     *     uint firstIndex;
//     *     uint baseVertex;
//     *     uint baseInstance;
//     * } DrawElementsIndirectCommand;</code></pre>
//     *
//     * <p>A single call to {@code glMultiDrawElementsIndirect} is equivalent, assuming no errors are generated to:</p>
//     *
//     * <pre><code>
//     * const ubyte *ptr = (const ubyte *)indirect;
//     * for ( i = 0; i &lt; primcount; i++ ) {
//     *     DrawElementsIndirect(mode, type, (DrawElementsIndirectCommand *)ptr);
//     *     if ( stride == 0 )
//     *         ptr += sizeof(DrawElementsIndirectCommand);
//     *     else
//     *         ptr += stride;
//     * }</code></pre>
//     *
//     * @param mode      what kind of primitives to render. One of:<br><table><tr><td>{@link GL11#GL_POINTS POINTS}</td><td>{@link GL11#GL_LINE_STRIP LINE_STRIP}</td><td>{@link GL11#GL_LINE_LOOP LINE_LOOP}</td><td>{@link GL11#GL_LINES LINES}</td><td>{@link GL11#GL_TRIANGLE_STRIP TRIANGLE_STRIP}</td><td>{@link GL11#GL_TRIANGLE_FAN TRIANGLE_FAN}</td><td>{@link GL11#GL_TRIANGLES TRIANGLES}</td></tr><tr><td>{@link GL32#GL_LINES_ADJACENCY LINES_ADJACENCY}</td><td>{@link GL32#GL_LINE_STRIP_ADJACENCY LINE_STRIP_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLES_ADJACENCY TRIANGLES_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLE_STRIP_ADJACENCY TRIANGLE_STRIP_ADJACENCY}</td><td>{@link GL40#GL_PATCHES PATCHES}</td><td>{@link GL11#GL_POLYGON POLYGON}</td><td>{@link GL11#GL_QUADS QUADS}</td></tr><tr><td>{@link GL11#GL_QUAD_STRIP QUAD_STRIP}</td></tr></table>
//     * @param type      the type of data in the buffer bound to the GL_ELEMENT_ARRAY_BUFFER binding. One of:<br><table><tr><td>{@link GL11#GL_UNSIGNED_BYTE UNSIGNED_BYTE}</td><td>{@link GL11#GL_UNSIGNED_SHORT UNSIGNED_SHORT}</td><td>{@link GL11#GL_UNSIGNED_INT UNSIGNED_INT}</td></tr></table>
//     * @param indirect  a structure containing an array of draw parameters
//     * @param primcount the number of elements in the array addressed by {@code indirect}
//     * @param stride    the distance in basic machine units between elements of the draw parameter array
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glMultiDrawElementsIndirect">Reference Page</a>
//     */
//    public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") ByteBuffer indirect, @NativeType("GLsizei") int primcount, @NativeType("GLsizei") int stride) {
//        if (CHECKS) {
//            check(indirect, primcount * (stride == 0 ? (5 * 4) : stride));
//        }
//        nglMultiDrawElementsIndirect(mode, type, memAddress(indirect), primcount, stride);
//    }
//
//    /**
//     * Renders multiple indexed primitives from array data, taking parameters from memory.
//     *
//     * <p>The parameters addressed by indirect are packed into a structure that takes the form (in C):</p>
//     *
//     * <pre><code>
//     * typedef struct {
//     *     uint count;
//     *     uint primCount;
//     *     uint firstIndex;
//     *     uint baseVertex;
//     *     uint baseInstance;
//     * } DrawElementsIndirectCommand;</code></pre>
//     *
//     * <p>A single call to {@code glMultiDrawElementsIndirect} is equivalent, assuming no errors are generated to:</p>
//     *
//     * <pre><code>
//     * const ubyte *ptr = (const ubyte *)indirect;
//     * for ( i = 0; i &lt; primcount; i++ ) {
//     *     DrawElementsIndirect(mode, type, (DrawElementsIndirectCommand *)ptr);
//     *     if ( stride == 0 )
//     *         ptr += sizeof(DrawElementsIndirectCommand);
//     *     else
//     *         ptr += stride;
//     * }</code></pre>
//     *
//     * @param mode      what kind of primitives to render. One of:<br><table><tr><td>{@link GL11#GL_POINTS POINTS}</td><td>{@link GL11#GL_LINE_STRIP LINE_STRIP}</td><td>{@link GL11#GL_LINE_LOOP LINE_LOOP}</td><td>{@link GL11#GL_LINES LINES}</td><td>{@link GL11#GL_TRIANGLE_STRIP TRIANGLE_STRIP}</td><td>{@link GL11#GL_TRIANGLE_FAN TRIANGLE_FAN}</td><td>{@link GL11#GL_TRIANGLES TRIANGLES}</td></tr><tr><td>{@link GL32#GL_LINES_ADJACENCY LINES_ADJACENCY}</td><td>{@link GL32#GL_LINE_STRIP_ADJACENCY LINE_STRIP_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLES_ADJACENCY TRIANGLES_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLE_STRIP_ADJACENCY TRIANGLE_STRIP_ADJACENCY}</td><td>{@link GL40#GL_PATCHES PATCHES}</td><td>{@link GL11#GL_POLYGON POLYGON}</td><td>{@link GL11#GL_QUADS QUADS}</td></tr><tr><td>{@link GL11#GL_QUAD_STRIP QUAD_STRIP}</td></tr></table>
//     * @param type      the type of data in the buffer bound to the GL_ELEMENT_ARRAY_BUFFER binding. One of:<br><table><tr><td>{@link GL11#GL_UNSIGNED_BYTE UNSIGNED_BYTE}</td><td>{@link GL11#GL_UNSIGNED_SHORT UNSIGNED_SHORT}</td><td>{@link GL11#GL_UNSIGNED_INT UNSIGNED_INT}</td></tr></table>
//     * @param indirect  a structure containing an array of draw parameters
//     * @param primcount the number of elements in the array addressed by {@code indirect}
//     * @param stride    the distance in basic machine units between elements of the draw parameter array
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glMultiDrawElementsIndirect">Reference Page</a>
//     */
//    public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") long indirect, @NativeType("GLsizei") int primcount, @NativeType("GLsizei") int stride) {
//        nglMultiDrawElementsIndirect(mode, type, indirect, primcount, stride);
//    }
//
//    /**
//     * Renders multiple indexed primitives from array data, taking parameters from memory.
//     *
//     * <p>The parameters addressed by indirect are packed into a structure that takes the form (in C):</p>
//     *
//     * <pre><code>
//     * typedef struct {
//     *     uint count;
//     *     uint primCount;
//     *     uint firstIndex;
//     *     uint baseVertex;
//     *     uint baseInstance;
//     * } DrawElementsIndirectCommand;</code></pre>
//     *
//     * <p>A single call to {@code glMultiDrawElementsIndirect} is equivalent, assuming no errors are generated to:</p>
//     *
//     * <pre><code>
//     * const ubyte *ptr = (const ubyte *)indirect;
//     * for ( i = 0; i &lt; primcount; i++ ) {
//     *     DrawElementsIndirect(mode, type, (DrawElementsIndirectCommand *)ptr);
//     *     if ( stride == 0 )
//     *         ptr += sizeof(DrawElementsIndirectCommand);
//     *     else
//     *         ptr += stride;
//     * }</code></pre>
//     *
//     * @param mode      what kind of primitives to render. One of:<br><table><tr><td>{@link GL11#GL_POINTS POINTS}</td><td>{@link GL11#GL_LINE_STRIP LINE_STRIP}</td><td>{@link GL11#GL_LINE_LOOP LINE_LOOP}</td><td>{@link GL11#GL_LINES LINES}</td><td>{@link GL11#GL_TRIANGLE_STRIP TRIANGLE_STRIP}</td><td>{@link GL11#GL_TRIANGLE_FAN TRIANGLE_FAN}</td><td>{@link GL11#GL_TRIANGLES TRIANGLES}</td></tr><tr><td>{@link GL32#GL_LINES_ADJACENCY LINES_ADJACENCY}</td><td>{@link GL32#GL_LINE_STRIP_ADJACENCY LINE_STRIP_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLES_ADJACENCY TRIANGLES_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLE_STRIP_ADJACENCY TRIANGLE_STRIP_ADJACENCY}</td><td>{@link GL40#GL_PATCHES PATCHES}</td><td>{@link GL11#GL_POLYGON POLYGON}</td><td>{@link GL11#GL_QUADS QUADS}</td></tr><tr><td>{@link GL11#GL_QUAD_STRIP QUAD_STRIP}</td></tr></table>
//     * @param type      the type of data in the buffer bound to the GL_ELEMENT_ARRAY_BUFFER binding. One of:<br><table><tr><td>{@link GL11#GL_UNSIGNED_BYTE UNSIGNED_BYTE}</td><td>{@link GL11#GL_UNSIGNED_SHORT UNSIGNED_SHORT}</td><td>{@link GL11#GL_UNSIGNED_INT UNSIGNED_INT}</td></tr></table>
//     * @param indirect  a structure containing an array of draw parameters
//     * @param primcount the number of elements in the array addressed by {@code indirect}
//     * @param stride    the distance in basic machine units between elements of the draw parameter array
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glMultiDrawElementsIndirect">Reference Page</a>
//     */
//    public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int mode, @NativeType("GLenum") int type, @NativeType("void const *") IntBuffer indirect, @NativeType("GLsizei") int primcount, @NativeType("GLsizei") int stride) {
//        if (CHECKS) {
//            check(indirect, (primcount * (stride == 0 ? (5 * 4) : stride)) >> 2);
//        }
//        nglMultiDrawElementsIndirect(mode, type, memAddress(indirect), primcount, stride);
//    }
//
//    // --- [ glGetProgramInterfaceiv ] ---
//
//    /** Unsafe version of: {@link #glGetProgramInterfaceiv GetProgramInterfaceiv} */
//    public static native void nglGetProgramInterfaceiv(int program, int programInterface, int pname, long params);
//
//    /**
//     * Queries a property of an interface in a program.
//     *
//     * @param program          the name of a program object whose interface to query
//     * @param programInterface a token identifying the interface within {@code program} to query. One of:<br><table><tr><td>{@link #GL_UNIFORM UNIFORM}</td><td>{@link #GL_UNIFORM_BLOCK UNIFORM_BLOCK}</td><td>{@link #GL_PROGRAM_INPUT PROGRAM_INPUT}</td></tr><tr><td>{@link #GL_PROGRAM_OUTPUT PROGRAM_OUTPUT}</td><td>{@link #GL_BUFFER_VARIABLE BUFFER_VARIABLE}</td><td>{@link #GL_SHADER_STORAGE_BLOCK SHADER_STORAGE_BLOCK}</td></tr><tr><td>{@link #GL_VERTEX_SUBROUTINE VERTEX_SUBROUTINE}</td><td>{@link #GL_TESS_CONTROL_SUBROUTINE TESS_CONTROL_SUBROUTINE}</td><td>{@link #GL_TESS_EVALUATION_SUBROUTINE TESS_EVALUATION_SUBROUTINE}</td></tr><tr><td>{@link #GL_GEOMETRY_SUBROUTINE GEOMETRY_SUBROUTINE}</td><td>{@link #GL_FRAGMENT_SUBROUTINE FRAGMENT_SUBROUTINE}</td><td>{@link #GL_COMPUTE_SUBROUTINE COMPUTE_SUBROUTINE}</td></tr><tr><td>{@link #GL_VERTEX_SUBROUTINE_UNIFORM VERTEX_SUBROUTINE_UNIFORM}</td><td>{@link #GL_TESS_CONTROL_SUBROUTINE_UNIFORM TESS_CONTROL_SUBROUTINE_UNIFORM}</td><td>{@link #GL_TESS_EVALUATION_SUBROUTINE_UNIFORM TESS_EVALUATION_SUBROUTINE_UNIFORM}</td></tr><tr><td>{@link #GL_GEOMETRY_SUBROUTINE_UNIFORM GEOMETRY_SUBROUTINE_UNIFORM}</td><td>{@link #GL_FRAGMENT_SUBROUTINE_UNIFORM FRAGMENT_SUBROUTINE_UNIFORM}</td><td>{@link #GL_COMPUTE_SUBROUTINE_UNIFORM COMPUTE_SUBROUTINE_UNIFORM}</td></tr><tr><td>{@link #GL_TRANSFORM_FEEDBACK_VARYING TRANSFORM_FEEDBACK_VARYING}</td><td>{@link GL42#GL_ATOMIC_COUNTER_BUFFER ATOMIC_COUNTER_BUFFER}</td></tr></table>
//     * @param pname            the name of the parameter within {@code programInterface} to query. One of:<br><table><tr><td>{@link #GL_ACTIVE_RESOURCES ACTIVE_RESOURCES}</td><td>{@link #GL_MAX_NAME_LENGTH MAX_NAME_LENGTH}</td><td>{@link #GL_MAX_NUM_ACTIVE_VARIABLES MAX_NUM_ACTIVE_VARIABLES}</td></tr><tr><td>{@link #GL_MAX_NUM_COMPATIBLE_SUBROUTINES MAX_NUM_COMPATIBLE_SUBROUTINES}</td></tr></table>
//     * @param params           a variable to retrieve the value of {@code pname} for the program interface
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetProgramInterface">Reference Page</a>
//     */
//    public static void glGetProgramInterfaceiv(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
//        if (CHECKS) {
//            check(params, 1);
//        }
//        nglGetProgramInterfaceiv(program, programInterface, pname, memAddress(params));
//    }
//
//    /**
//     * Queries a property of an interface in a program.
//     *
//     * @param program          the name of a program object whose interface to query
//     * @param programInterface a token identifying the interface within {@code program} to query. One of:<br><table><tr><td>{@link #GL_UNIFORM UNIFORM}</td><td>{@link #GL_UNIFORM_BLOCK UNIFORM_BLOCK}</td><td>{@link #GL_PROGRAM_INPUT PROGRAM_INPUT}</td></tr><tr><td>{@link #GL_PROGRAM_OUTPUT PROGRAM_OUTPUT}</td><td>{@link #GL_BUFFER_VARIABLE BUFFER_VARIABLE}</td><td>{@link #GL_SHADER_STORAGE_BLOCK SHADER_STORAGE_BLOCK}</td></tr><tr><td>{@link #GL_VERTEX_SUBROUTINE VERTEX_SUBROUTINE}</td><td>{@link #GL_TESS_CONTROL_SUBROUTINE TESS_CONTROL_SUBROUTINE}</td><td>{@link #GL_TESS_EVALUATION_SUBROUTINE TESS_EVALUATION_SUBROUTINE}</td></tr><tr><td>{@link #GL_GEOMETRY_SUBROUTINE GEOMETRY_SUBROUTINE}</td><td>{@link #GL_FRAGMENT_SUBROUTINE FRAGMENT_SUBROUTINE}</td><td>{@link #GL_COMPUTE_SUBROUTINE COMPUTE_SUBROUTINE}</td></tr><tr><td>{@link #GL_VERTEX_SUBROUTINE_UNIFORM VERTEX_SUBROUTINE_UNIFORM}</td><td>{@link #GL_TESS_CONTROL_SUBROUTINE_UNIFORM TESS_CONTROL_SUBROUTINE_UNIFORM}</td><td>{@link #GL_TESS_EVALUATION_SUBROUTINE_UNIFORM TESS_EVALUATION_SUBROUTINE_UNIFORM}</td></tr><tr><td>{@link #GL_GEOMETRY_SUBROUTINE_UNIFORM GEOMETRY_SUBROUTINE_UNIFORM}</td><td>{@link #GL_FRAGMENT_SUBROUTINE_UNIFORM FRAGMENT_SUBROUTINE_UNIFORM}</td><td>{@link #GL_COMPUTE_SUBROUTINE_UNIFORM COMPUTE_SUBROUTINE_UNIFORM}</td></tr><tr><td>{@link #GL_TRANSFORM_FEEDBACK_VARYING TRANSFORM_FEEDBACK_VARYING}</td><td>{@link GL42#GL_ATOMIC_COUNTER_BUFFER ATOMIC_COUNTER_BUFFER}</td></tr></table>
//     * @param pname            the name of the parameter within {@code programInterface} to query. One of:<br><table><tr><td>{@link #GL_ACTIVE_RESOURCES ACTIVE_RESOURCES}</td><td>{@link #GL_MAX_NAME_LENGTH MAX_NAME_LENGTH}</td><td>{@link #GL_MAX_NUM_ACTIVE_VARIABLES MAX_NUM_ACTIVE_VARIABLES}</td></tr><tr><td>{@link #GL_MAX_NUM_COMPATIBLE_SUBROUTINES MAX_NUM_COMPATIBLE_SUBROUTINES}</td></tr></table>
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetProgramInterface">Reference Page</a>
//     */
//    @NativeType("void")
//    public static int glGetProgramInterfacei(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLenum") int pname) {
//        MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
//        try {
//            IntBuffer params = stack.callocInt(1);
//            nglGetProgramInterfaceiv(program, programInterface, pname, memAddress(params));
//            return params.get(0);
//        } finally {
//            stack.setPointer(stackPointer);
//        }
//    }
//
//    // --- [ glGetProgramResourceIndex ] ---
//
//    /** Unsafe version of: {@link #glGetProgramResourceIndex GetProgramResourceIndex} */
//    public static native int nglGetProgramResourceIndex(int program, int programInterface, long name);
//
//    /**
//     * Queries the index of a named resource within a program.
//     *
//     * @param program          the name of a program object whose resources to query
//     * @param programInterface a token identifying the interface within {@code program} containing the resource named {Wcode name}. One of:<br><table><tr><td>{@link #GL_UNIFORM UNIFORM}</td><td>{@link #GL_UNIFORM_BLOCK UNIFORM_BLOCK}</td><td>{@link #GL_PROGRAM_INPUT PROGRAM_INPUT}</td></tr><tr><td>{@link #GL_PROGRAM_OUTPUT PROGRAM_OUTPUT}</td><td>{@link #GL_BUFFER_VARIABLE BUFFER_VARIABLE}</td><td>{@link #GL_SHADER_STORAGE_BLOCK SHADER_STORAGE_BLOCK}</td></tr><tr><td>{@link #GL_VERTEX_SUBROUTINE VERTEX_SUBROUTINE}</td><td>{@link #GL_TESS_CONTROL_SUBROUTINE TESS_CONTROL_SUBROUTINE}</td><td>{@link #GL_TESS_EVALUATION_SUBROUTINE TESS_EVALUATION_SUBROUTINE}</td></tr><tr><td>{@link #GL_GEOMETRY_SUBROUTINE GEOMETRY_SUBROUTINE}</td><td>{@link #GL_FRAGMENT_SUBROUTINE FRAGMENT_SUBROUTINE}</td><td>{@link #GL_COMPUTE_SUBROUTINE COMPUTE_SUBROUTINE}</td></tr><tr><td>{@link #GL_VERTEX_SUBROUTINE_UNIFORM VERTEX_SUBROUTINE_UNIFORM}</td><td>{@link #GL_TESS_CONTROL_SUBROUTINE_UNIFORM TESS_CONTROL_SUBROUTINE_UNIFORM}</td><td>{@link #GL_TESS_EVALUATION_SUBROUTINE_UNIFORM TESS_EVALUATION_SUBROUTINE_UNIFORM}</td></tr><tr><td>{@link #GL_GEOMETRY_SUBROUTINE_UNIFORM GEOMETRY_SUBROUTINE_UNIFORM}</td><td>{@link #GL_FRAGMENT_SUBROUTINE_UNIFORM FRAGMENT_SUBROUTINE_UNIFORM}</td><td>{@link #GL_COMPUTE_SUBROUTINE_UNIFORM COMPUTE_SUBROUTINE_UNIFORM}</td></tr><tr><td>{@link #GL_TRANSFORM_FEEDBACK_VARYING TRANSFORM_FEEDBACK_VARYING}</td><td>{@link GL42#GL_ATOMIC_COUNTER_BUFFER ATOMIC_COUNTER_BUFFER}</td></tr></table>
//     * @param name             the name of the resource to query the index of
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetProgramResourceIndex">Reference Page</a>
//     */
//    @NativeType("GLuint")
//    public static int glGetProgramResourceIndex(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLchar const *") ByteBuffer name) {
//        if (CHECKS) {
//            checkNT1(name);
//        }
//        return nglGetProgramResourceIndex(program, programInterface, memAddress(name));
//    }
//
//    /**
//     * Queries the index of a named resource within a program.
//     *
//     * @param program          the name of a program object whose resources to query
//     * @param programInterface a token identifying the interface within {@code program} containing the resource named {Wcode name}. One of:<br><table><tr><td>{@link #GL_UNIFORM UNIFORM}</td><td>{@link #GL_UNIFORM_BLOCK UNIFORM_BLOCK}</td><td>{@link #GL_PROGRAM_INPUT PROGRAM_INPUT}</td></tr><tr><td>{@link #GL_PROGRAM_OUTPUT PROGRAM_OUTPUT}</td><td>{@link #GL_BUFFER_VARIABLE BUFFER_VARIABLE}</td><td>{@link #GL_SHADER_STORAGE_BLOCK SHADER_STORAGE_BLOCK}</td></tr><tr><td>{@link #GL_VERTEX_SUBROUTINE VERTEX_SUBROUTINE}</td><td>{@link #GL_TESS_CONTROL_SUBROUTINE TESS_CONTROL_SUBROUTINE}</td><td>{@link #GL_TESS_EVALUATION_SUBROUTINE TESS_EVALUATION_SUBROUTINE}</td></tr><tr><td>{@link #GL_GEOMETRY_SUBROUTINE GEOMETRY_SUBROUTINE}</td><td>{@link #GL_FRAGMENT_SUBROUTINE FRAGMENT_SUBROUTINE}</td><td>{@link #GL_COMPUTE_SUBROUTINE COMPUTE_SUBROUTINE}</td></tr><tr><td>{@link #GL_VERTEX_SUBROUTINE_UNIFORM VERTEX_SUBROUTINE_UNIFORM}</td><td>{@link #GL_TESS_CONTROL_SUBROUTINE_UNIFORM TESS_CONTROL_SUBROUTINE_UNIFORM}</td><td>{@link #GL_TESS_EVALUATION_SUBROUTINE_UNIFORM TESS_EVALUATION_SUBROUTINE_UNIFORM}</td></tr><tr><td>{@link #GL_GEOMETRY_SUBROUTINE_UNIFORM GEOMETRY_SUBROUTINE_UNIFORM}</td><td>{@link #GL_FRAGMENT_SUBROUTINE_UNIFORM FRAGMENT_SUBROUTINE_UNIFORM}</td><td>{@link #GL_COMPUTE_SUBROUTINE_UNIFORM COMPUTE_SUBROUTINE_UNIFORM}</td></tr><tr><td>{@link #GL_TRANSFORM_FEEDBACK_VARYING TRANSFORM_FEEDBACK_VARYING}</td><td>{@link GL42#GL_ATOMIC_COUNTER_BUFFER ATOMIC_COUNTER_BUFFER}</td></tr></table>
//     * @param name             the name of the resource to query the index of
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetProgramResourceIndex">Reference Page</a>
//     */
//    @NativeType("GLuint")
//    public static int glGetProgramResourceIndex(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLchar const *") CharSequence name) {
//        MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
//        try {
//            stack.nUTF8(name, true);
//            long nameEncoded = stack.getPointerAddress();
//            return nglGetProgramResourceIndex(program, programInterface, nameEncoded);
//        } finally {
//            stack.setPointer(stackPointer);
//        }
//    }
//
//    // --- [ glGetProgramResourceName ] ---
//
//    /**
//     * Unsafe version of: {@link #glGetProgramResourceName GetProgramResourceName}
//     *
//     * @param bufSize the size of the character array whose address is given by {@code name}
//     */
//    public static native void nglGetProgramResourceName(int program, int programInterface, int index, int bufSize, long length, long name);
//
//    /**
//     * Queries the name of an indexed resource within a program.
//     *
//     * @param program          the name of a program object whose resources to query
//     * @param programInterface a token identifying the interface within {@code program} containing the indexed resource. One of:<br><table><tr><td>{@link #GL_UNIFORM UNIFORM}</td><td>{@link #GL_UNIFORM_BLOCK UNIFORM_BLOCK}</td><td>{@link #GL_PROGRAM_INPUT PROGRAM_INPUT}</td></tr><tr><td>{@link #GL_PROGRAM_OUTPUT PROGRAM_OUTPUT}</td><td>{@link #GL_BUFFER_VARIABLE BUFFER_VARIABLE}</td><td>{@link #GL_SHADER_STORAGE_BLOCK SHADER_STORAGE_BLOCK}</td></tr><tr><td>{@link #GL_VERTEX_SUBROUTINE VERTEX_SUBROUTINE}</td><td>{@link #GL_TESS_CONTROL_SUBROUTINE TESS_CONTROL_SUBROUTINE}</td><td>{@link #GL_TESS_EVALUATION_SUBROUTINE TESS_EVALUATION_SUBROUTINE}</td></tr><tr><td>{@link #GL_GEOMETRY_SUBROUTINE GEOMETRY_SUBROUTINE}</td><td>{@link #GL_FRAGMENT_SUBROUTINE FRAGMENT_SUBROUTINE}</td><td>{@link #GL_COMPUTE_SUBROUTINE COMPUTE_SUBROUTINE}</td></tr><tr><td>{@link #GL_VERTEX_SUBROUTINE_UNIFORM VERTEX_SUBROUTINE_UNIFORM}</td><td>{@link #GL_TESS_CONTROL_SUBROUTINE_UNIFORM TESS_CONTROL_SUBROUTINE_UNIFORM}</td><td>{@link #GL_TESS_EVALUATION_SUBROUTINE_UNIFORM TESS_EVALUATION_SUBROUTINE_UNIFORM}</td></tr><tr><td>{@link #GL_GEOMETRY_SUBROUTINE_UNIFORM GEOMETRY_SUBROUTINE_UNIFORM}</td><td>{@link #GL_FRAGMENT_SUBROUTINE_UNIFORM FRAGMENT_SUBROUTINE_UNIFORM}</td><td>{@link #GL_COMPUTE_SUBROUTINE_UNIFORM COMPUTE_SUBROUTINE_UNIFORM}</td></tr><tr><td>{@link #GL_TRANSFORM_FEEDBACK_VARYING TRANSFORM_FEEDBACK_VARYING}</td><td>{@link GL42#GL_ATOMIC_COUNTER_BUFFER ATOMIC_COUNTER_BUFFER}</td></tr></table>
//     * @param index            the index of the resource within {@code programInterface} of {@code program}
//     * @param length           a variable which will receive the length of the resource name
//     * @param name             a character array into which will be written the name of the resource
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetProgramResourceName">Reference Page</a>
//     */
//    public static void glGetProgramResourceName(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLuint") int index, @Nullable @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer name) {
//        if (CHECKS) {
//            checkSafe(length, 1);
//        }
//        nglGetProgramResourceName(program, programInterface, index, name.remaining(), memAddressSafe(length), memAddress(name));
//    }
//
//    /**
//     * Queries the name of an indexed resource within a program.
//     *
//     * @param program          the name of a program object whose resources to query
//     * @param programInterface a token identifying the interface within {@code program} containing the indexed resource. One of:<br><table><tr><td>{@link #GL_UNIFORM UNIFORM}</td><td>{@link #GL_UNIFORM_BLOCK UNIFORM_BLOCK}</td><td>{@link #GL_PROGRAM_INPUT PROGRAM_INPUT}</td></tr><tr><td>{@link #GL_PROGRAM_OUTPUT PROGRAM_OUTPUT}</td><td>{@link #GL_BUFFER_VARIABLE BUFFER_VARIABLE}</td><td>{@link #GL_SHADER_STORAGE_BLOCK SHADER_STORAGE_BLOCK}</td></tr><tr><td>{@link #GL_VERTEX_SUBROUTINE VERTEX_SUBROUTINE}</td><td>{@link #GL_TESS_CONTROL_SUBROUTINE TESS_CONTROL_SUBROUTINE}</td><td>{@link #GL_TESS_EVALUATION_SUBROUTINE TESS_EVALUATION_SUBROUTINE}</td></tr><tr><td>{@link #GL_GEOMETRY_SUBROUTINE GEOMETRY_SUBROUTINE}</td><td>{@link #GL_FRAGMENT_SUBROUTINE FRAGMENT_SUBROUTINE}</td><td>{@link #GL_COMPUTE_SUBROUTINE COMPUTE_SUBROUTINE}</td></tr><tr><td>{@link #GL_VERTEX_SUBROUTINE_UNIFORM VERTEX_SUBROUTINE_UNIFORM}</td><td>{@link #GL_TESS_CONTROL_SUBROUTINE_UNIFORM TESS_CONTROL_SUBROUTINE_UNIFORM}</td><td>{@link #GL_TESS_EVALUATION_SUBROUTINE_UNIFORM TESS_EVALUATION_SUBROUTINE_UNIFORM}</td></tr><tr><td>{@link #GL_GEOMETRY_SUBROUTINE_UNIFORM GEOMETRY_SUBROUTINE_UNIFORM}</td><td>{@link #GL_FRAGMENT_SUBROUTINE_UNIFORM FRAGMENT_SUBROUTINE_UNIFORM}</td><td>{@link #GL_COMPUTE_SUBROUTINE_UNIFORM COMPUTE_SUBROUTINE_UNIFORM}</td></tr><tr><td>{@link #GL_TRANSFORM_FEEDBACK_VARYING TRANSFORM_FEEDBACK_VARYING}</td><td>{@link GL42#GL_ATOMIC_COUNTER_BUFFER ATOMIC_COUNTER_BUFFER}</td></tr></table>
//     * @param index            the index of the resource within {@code programInterface} of {@code program}
//     * @param bufSize          the size of the character array whose address is given by {@code name}
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetProgramResourceName">Reference Page</a>
//     */
//    @NativeType("void")
//    public static String glGetProgramResourceName(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLuint") int index, @NativeType("GLsizei") int bufSize) {
//        MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
//        try {
//            IntBuffer length = stack.ints(0);
//            ByteBuffer name = stack.malloc(bufSize);
//            nglGetProgramResourceName(program, programInterface, index, bufSize, memAddress(length), memAddress(name));
//            return memASCII(name, length.get(0));
//        } finally {
//            stack.setPointer(stackPointer);
//        }
//    }
//
//    /**
//     * Queries the name of an indexed resource within a program.
//     *
//     * @param program          the name of a program object whose resources to query
//     * @param programInterface a token identifying the interface within {@code program} containing the indexed resource. One of:<br><table><tr><td>{@link #GL_UNIFORM UNIFORM}</td><td>{@link #GL_UNIFORM_BLOCK UNIFORM_BLOCK}</td><td>{@link #GL_PROGRAM_INPUT PROGRAM_INPUT}</td></tr><tr><td>{@link #GL_PROGRAM_OUTPUT PROGRAM_OUTPUT}</td><td>{@link #GL_BUFFER_VARIABLE BUFFER_VARIABLE}</td><td>{@link #GL_SHADER_STORAGE_BLOCK SHADER_STORAGE_BLOCK}</td></tr><tr><td>{@link #GL_VERTEX_SUBROUTINE VERTEX_SUBROUTINE}</td><td>{@link #GL_TESS_CONTROL_SUBROUTINE TESS_CONTROL_SUBROUTINE}</td><td>{@link #GL_TESS_EVALUATION_SUBROUTINE TESS_EVALUATION_SUBROUTINE}</td></tr><tr><td>{@link #GL_GEOMETRY_SUBROUTINE GEOMETRY_SUBROUTINE}</td><td>{@link #GL_FRAGMENT_SUBROUTINE FRAGMENT_SUBROUTINE}</td><td>{@link #GL_COMPUTE_SUBROUTINE COMPUTE_SUBROUTINE}</td></tr><tr><td>{@link #GL_VERTEX_SUBROUTINE_UNIFORM VERTEX_SUBROUTINE_UNIFORM}</td><td>{@link #GL_TESS_CONTROL_SUBROUTINE_UNIFORM TESS_CONTROL_SUBROUTINE_UNIFORM}</td><td>{@link #GL_TESS_EVALUATION_SUBROUTINE_UNIFORM TESS_EVALUATION_SUBROUTINE_UNIFORM}</td></tr><tr><td>{@link #GL_GEOMETRY_SUBROUTINE_UNIFORM GEOMETRY_SUBROUTINE_UNIFORM}</td><td>{@link #GL_FRAGMENT_SUBROUTINE_UNIFORM FRAGMENT_SUBROUTINE_UNIFORM}</td><td>{@link #GL_COMPUTE_SUBROUTINE_UNIFORM COMPUTE_SUBROUTINE_UNIFORM}</td></tr><tr><td>{@link #GL_TRANSFORM_FEEDBACK_VARYING TRANSFORM_FEEDBACK_VARYING}</td><td>{@link GL42#GL_ATOMIC_COUNTER_BUFFER ATOMIC_COUNTER_BUFFER}</td></tr></table>
//     * @param index            the index of the resource within {@code programInterface} of {@code program}
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetProgramResourceName">Reference Page</a>
//     */
//    @NativeType("void")
//    public static String glGetProgramResourceName(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLuint") int index) {
//        return glGetProgramResourceName(program, programInterface, index, glGetProgramInterfacei(program, programInterface, GL_MAX_NAME_LENGTH));
//    }
//
//    // --- [ glGetProgramResourceiv ] ---
//
//    /**
//     * Unsafe version of: {@link #glGetProgramResourceiv GetProgramResourceiv}
//     *
//     * @param propCount the number of properties in {@code props}
//     * @param bufSize   the size of the integer array whose address is given by {@code params}
//     */
//    public static native void nglGetProgramResourceiv(int program, int programInterface, int index, int propCount, long props, int bufSize, long length, long params);
//
//    /**
//     * Retrieves values for multiple properties of a single active resource within a program object.
//     *
//     * @param program          the name of a program object whose resources to query
//     * @param programInterface a token identifying the interface within {@code program} containing the resource named {@code name}. One of:<br><table><tr><td>{@link #GL_UNIFORM UNIFORM}</td><td>{@link #GL_UNIFORM_BLOCK UNIFORM_BLOCK}</td><td>{@link #GL_PROGRAM_INPUT PROGRAM_INPUT}</td></tr><tr><td>{@link #GL_PROGRAM_OUTPUT PROGRAM_OUTPUT}</td><td>{@link #GL_BUFFER_VARIABLE BUFFER_VARIABLE}</td><td>{@link #GL_SHADER_STORAGE_BLOCK SHADER_STORAGE_BLOCK}</td></tr><tr><td>{@link #GL_VERTEX_SUBROUTINE VERTEX_SUBROUTINE}</td><td>{@link #GL_TESS_CONTROL_SUBROUTINE TESS_CONTROL_SUBROUTINE}</td><td>{@link #GL_TESS_EVALUATION_SUBROUTINE TESS_EVALUATION_SUBROUTINE}</td></tr><tr><td>{@link #GL_GEOMETRY_SUBROUTINE GEOMETRY_SUBROUTINE}</td><td>{@link #GL_FRAGMENT_SUBROUTINE FRAGMENT_SUBROUTINE}</td><td>{@link #GL_COMPUTE_SUBROUTINE COMPUTE_SUBROUTINE}</td></tr><tr><td>{@link #GL_VERTEX_SUBROUTINE_UNIFORM VERTEX_SUBROUTINE_UNIFORM}</td><td>{@link #GL_TESS_CONTROL_SUBROUTINE_UNIFORM TESS_CONTROL_SUBROUTINE_UNIFORM}</td><td>{@link #GL_TESS_EVALUATION_SUBROUTINE_UNIFORM TESS_EVALUATION_SUBROUTINE_UNIFORM}</td></tr><tr><td>{@link #GL_GEOMETRY_SUBROUTINE_UNIFORM GEOMETRY_SUBROUTINE_UNIFORM}</td><td>{@link #GL_FRAGMENT_SUBROUTINE_UNIFORM FRAGMENT_SUBROUTINE_UNIFORM}</td><td>{@link #GL_COMPUTE_SUBROUTINE_UNIFORM COMPUTE_SUBROUTINE_UNIFORM}</td></tr><tr><td>{@link #GL_TRANSFORM_FEEDBACK_VARYING TRANSFORM_FEEDBACK_VARYING}</td><td>{@link GL42#GL_ATOMIC_COUNTER_BUFFER ATOMIC_COUNTER_BUFFER}</td></tr></table>
//     * @param index            the active resource index
//     * @param props            an array that will receive the active resource properties
//     * @param length           a variable which will receive the number of values returned
//     * @param params           an array that will receive the property values
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetProgramResource">Reference Page</a>
//     */
//    public static void glGetProgramResourceiv(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLuint") int index, @NativeType("GLenum const *") IntBuffer props, @Nullable @NativeType("GLsizei *") IntBuffer length, @NativeType("GLint *") IntBuffer params) {
//        if (CHECKS) {
//            checkSafe(length, 1);
//        }
//        nglGetProgramResourceiv(program, programInterface, index, props.remaining(), memAddress(props), params.remaining(), memAddressSafe(length), memAddress(params));
//    }
//
//    // --- [ glGetProgramResourceLocation ] ---
//
//    /** Unsafe version of: {@link #glGetProgramResourceLocation GetProgramResourceLocation} */
//    public static native int nglGetProgramResourceLocation(int program, int programInterface, long name);
//
//    /**
//     * Queries the location of a named resource within a program.
//     *
//     * @param program          the name of a program object whose resources to query
//     * @param programInterface a token identifying the interface within {@code program} containing the resource named {@code name}
//     * @param name             the name of the resource to query the location of
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetProgramResourceLocation">Reference Page</a>
//     */
//    @NativeType("GLint")
//    public static int glGetProgramResourceLocation(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLchar const *") ByteBuffer name) {
//        if (CHECKS) {
//            checkNT1(name);
//        }
//        return nglGetProgramResourceLocation(program, programInterface, memAddress(name));
//    }
//
//    /**
//     * Queries the location of a named resource within a program.
//     *
//     * @param program          the name of a program object whose resources to query
//     * @param programInterface a token identifying the interface within {@code program} containing the resource named {@code name}
//     * @param name             the name of the resource to query the location of
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetProgramResourceLocation">Reference Page</a>
//     */
//    @NativeType("GLint")
//    public static int glGetProgramResourceLocation(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLchar const *") CharSequence name) {
//        MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
//        try {
//            stack.nASCII(name, true);
//            long nameEncoded = stack.getPointerAddress();
//            return nglGetProgramResourceLocation(program, programInterface, nameEncoded);
//        } finally {
//            stack.setPointer(stackPointer);
//        }
//    }
//
//    // --- [ glGetProgramResourceLocationIndex ] ---
//
//    /** Unsafe version of: {@link #glGetProgramResourceLocationIndex GetProgramResourceLocationIndex} */
//    public static native int nglGetProgramResourceLocationIndex(int program, int programInterface, long name);
//
//    /**
//     * Queries the fragment color index of a named variable within a program.
//     *
//     * @param program          the name of a program object whose resources to query
//     * @param programInterface a token identifying the interface within {@code program} containing the resource named {@code name}. Must be:<br><table><tr><td>{@link #GL_PROGRAM_OUTPUT PROGRAM_OUTPUT}</td></tr></table>
//     * @param name             the name of the resource to query the location of
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetProgramResourceLocationIndex">Reference Page</a>
//     */
//    @NativeType("GLint")
//    public static int glGetProgramResourceLocationIndex(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLchar const *") ByteBuffer name) {
//        if (CHECKS) {
//            checkNT1(name);
//        }
//        return nglGetProgramResourceLocationIndex(program, programInterface, memAddress(name));
//    }
//
//    /**
//     * Queries the fragment color index of a named variable within a program.
//     *
//     * @param program          the name of a program object whose resources to query
//     * @param programInterface a token identifying the interface within {@code program} containing the resource named {@code name}. Must be:<br><table><tr><td>{@link #GL_PROGRAM_OUTPUT PROGRAM_OUTPUT}</td></tr></table>
//     * @param name             the name of the resource to query the location of
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glGetProgramResourceLocationIndex">Reference Page</a>
//     */
//    @NativeType("GLint")
//    public static int glGetProgramResourceLocationIndex(@NativeType("GLuint") int program, @NativeType("GLenum") int programInterface, @NativeType("GLchar const *") CharSequence name) {
//        MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
//        try {
//            stack.nASCII(name, true);
//            long nameEncoded = stack.getPointerAddress();
//            return nglGetProgramResourceLocationIndex(program, programInterface, nameEncoded);
//        } finally {
//            stack.setPointer(stackPointer);
//        }
//    }
//
//    // --- [ glShaderStorageBlockBinding ] ---
//
//    /**
//     * Changes an active shader storage block binding.
//     *
//     * @param program             the name of the program containing the block whose binding to change
//     * @param storageBlockIndex   the index storage block within the program
//     * @param storageBlockBinding the index storage block binding to associate with the specified storage block
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glShaderStorageBlockBinding">Reference Page</a>
//     */
//    public static native void glShaderStorageBlockBinding(@NativeType("GLuint") int program, @NativeType("GLuint") int storageBlockIndex, @NativeType("GLuint") int storageBlockBinding);
//
//    // --- [ glTexBufferRange ] ---
//
//    /**
//     * Binds a range of a buffer's data store to a buffer texture.
//     *
//     * @param target         the target of the operation. Must be:<br><table><tr><td>{@link GL31#GL_TEXTURE_BUFFER TEXTURE_BUFFER}</td></tr></table>
//     * @param internalformat the internal format of the data in the store belonging to {@code buffer}
//     * @param buffer         the name of the buffer object whose storage to attach to the active buffer texture
//     * @param offset         the offset of the start of the range of the buffer's data store to attach
//     * @param size           the size of the range of the buffer's data store to attach
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glTexBufferRange">Reference Page</a>
//     */
//    public static native void glTexBufferRange(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizeiptr") long size);
//
//    // --- [ glTexStorage2DMultisample ] ---
//
//    /**
//     * Specifies storage for a two-dimensional multisample texture.
//     *
//     * @param target               the target of the operation. One of:<br><table><tr><td>{@link GL32#GL_TEXTURE_2D_MULTISAMPLE TEXTURE_2D_MULTISAMPLE}</td><td>{@link GL32#GL_PROXY_TEXTURE_2D_MULTISAMPLE PROXY_TEXTURE_2D_MULTISAMPLE}</td></tr></table>
//     * @param samples              the number of samples in the texture
//     * @param internalformat       the sized internal format to be used to store texture image data
//     * @param width                the width of the texture, in texels
//     * @param height               the height of the texture, in texels
//     * @param fixedsamplelocations whether the image will use identical sample locations and the same number of samples for all texels in the image, and the sample locations will not
//     *                             depend on the internal format or size of the image
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glTexStorage2DMultisample">Reference Page</a>
//     */
//    public static native void glTexStorage2DMultisample(@NativeType("GLenum") int target, @NativeType("GLsizei") int samples, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLboolean") boolean fixedsamplelocations);
//
//    // --- [ glTexStorage3DMultisample ] ---
//
//    /**
//     * Specifies storage for a two-dimensional multisample array texture.
//     *
//     * @param target               the target of the operation. One of:<br><table><tr><td>{@link GL32#GL_TEXTURE_2D_MULTISAMPLE_ARRAY TEXTURE_2D_MULTISAMPLE_ARRAY}</td><td>{@link GL32#GL_PROXY_TEXTURE_2D_MULTISAMPLE PROXY_TEXTURE_2D_MULTISAMPLE}</td></tr></table>
//     * @param samples              the number of samples in the texture
//     * @param internalformat       the sized internal format to be used to store texture image data
//     * @param width                the width of the texture, in texels
//     * @param height               the height of the texture, in texels
//     * @param depth                the depth of the texture, in texels
//     * @param fixedsamplelocations whether the image will use identical sample locations and the same number of samples for all texels in the image, and the sample locations will not
//     *                             depend on the internal format or size of the image
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glTexStorage3DMultisample">Reference Page</a>
//     */
//    public static native void glTexStorage3DMultisample(@NativeType("GLenum") int target, @NativeType("GLsizei") int samples, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLsizei") int depth, @NativeType("GLboolean") boolean fixedsamplelocations);
//
//    // --- [ glTextureView ] ---
//
//    /**
//     * Initializes a texture as a data alias of another texture's data store.
//     *
//     * @param texture        the texture object to be initialized as a view
//     * @param target         the target to be used for the newly initialized texture
//     * @param origtexture    the name of a texture object of which to make a view
//     * @param internalformat the internal format for the newly created view
//     * @param minlevel       the  lowest level of detail of the view
//     * @param numlevels      the number of levels of detail to include in the view
//     * @param minlayer       the index of the first layer to include in the view
//     * @param numlayers      the number of layers to include in the view
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glTextureView">Reference Page</a>
//     */
//    public static native void glTextureView(@NativeType("GLuint") int texture, @NativeType("GLenum") int target, @NativeType("GLuint") int origtexture, @NativeType("GLenum") int internalformat, @NativeType("GLuint") int minlevel, @NativeType("GLuint") int numlevels, @NativeType("GLuint") int minlayer, @NativeType("GLuint") int numlayers);
//
//    // --- [ glBindVertexBuffer ] ---
//
//    /**
//     * Binds a buffer to a vertex buffer bind point.
//     *
//     * @param bindingindex the index of the vertex buffer binding point to which to bind the buffer
//     * @param buffer       the name of an existing buffer to bind to the vertex buffer binding point
//     * @param offset       the offset of the first element of the buffer
//     * @param stride       the distance between elements within the buffer
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glBindVertexBuffer">Reference Page</a>
//     */
//    public static native void glBindVertexBuffer(@NativeType("GLuint") int bindingindex, @NativeType("GLuint") int buffer, @NativeType("GLintptr") long offset, @NativeType("GLsizei") int stride);
//
//    // --- [ glVertexAttribFormat ] ---
//
//    /**
//     * Specifies the organization of data in vertex arrays.
//     *
//     * @param attribindex    the generic vertex attribute array being described
//     * @param size           the number of values per vertex that are stored in the array. One of:<br><table><tr><td>1</td><td>2</td><td>3</td><td>4</td><td>{@link GL12#GL_BGRA BGRA}</td></tr></table>
//     * @param type           the type of the data stored in the array
//     * @param normalized     if true then integer data is normalized to the range [-1, 1] or [0, 1] if it is signed or unsigned, respectively. If false then integer data is
//     *                       directly converted to floating point.
//     * @param relativeoffset the offset, measured in basic machine units of the first element relative to the start of the vertex buffer binding this attribute fetches from
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glVertexAttribFormat">Reference Page</a>
//     */
//    public static native void glVertexAttribFormat(@NativeType("GLuint") int attribindex, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint") int relativeoffset);
//
//    // --- [ glVertexAttribIFormat ] ---
//
//    /**
//     * Specifies the organization of pure integer data in vertex arrays.
//     *
//     * @param attribindex    the generic vertex attribute array being described
//     * @param size           the number of values per vertex that are stored in the array. One of:<br><table><tr><td>1</td><td>2</td><td>3</td><td>4</td><td>{@link GL12#GL_BGRA BGRA}</td></tr></table>
//     * @param type           the type of the data stored in the array
//     * @param relativeoffset the offset, measured in basic machine units of the first element relative to the start of the vertex buffer binding this attribute fetches from
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glVertexAttribIFormat">Reference Page</a>
//     */
//    public static native void glVertexAttribIFormat(@NativeType("GLuint") int attribindex, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLuint") int relativeoffset);
//
//    // --- [ glVertexAttribLFormat ] ---
//
//    /**
//     * Specifies the organization of 64-bit double data in vertex arrays.
//     *
//     * @param attribindex    the generic vertex attribute array being described
//     * @param size           the number of values per vertex that are stored in the array. One of:<br><table><tr><td>1</td><td>2</td><td>3</td><td>4</td><td>{@link GL12#GL_BGRA BGRA}</td></tr></table>
//     * @param type           the type of the data stored in the array
//     * @param relativeoffset the offset, measured in basic machine units of the first element relative to the start of the vertex buffer binding this attribute fetches from
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glVertexAttribLFormat">Reference Page</a>
//     */
//    public static native void glVertexAttribLFormat(@NativeType("GLuint") int attribindex, @NativeType("GLint") int size, @NativeType("GLenum") int type, @NativeType("GLuint") int relativeoffset);
//
//    // --- [ glVertexAttribBinding ] ---
//
//    /**
//     * Associate a vertex attribute and a vertex buffer binding.
//     *
//     * @param attribindex  the index of the attribute to associate with a vertex buffer binding
//     * @param bindingindex the index of the vertex buffer binding with which to associate the generic vertex attribute
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glVertexAttribBinding">Reference Page</a>
//     */
//    public static native void glVertexAttribBinding(@NativeType("GLuint") int attribindex, @NativeType("GLuint") int bindingindex);
//
//    // --- [ glVertexBindingDivisor ] ---
//
//    /**
//     * Modifies the rate at which generic vertex attributes advance during instanced rendering.
//     *
//     * @param bindingindex the index of the generic vertex attribute
//     * @param divisor      the number of instances that will pass between updates of the generic attribute at slot {@code index}
//     *
//     * @see <a target="_blank" href="http://docs.gl/gl4/glVertexBindingDivisor">Reference Page</a>
//     */
//    public static native void glVertexBindingDivisor(@NativeType("GLuint") int bindingindex, @NativeType("GLuint") int divisor);
}