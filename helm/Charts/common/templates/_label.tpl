{{- define "common.label.value" -}}
{{- $name := .name | default "" -}}
{{- if $name -}}
{{- $name = printf "-%s" $name -}}
{{- end -}}
{{- if not .labels -}}
app: {{ include "common.name.value" . }}{{ $name }}
{{- else }}
{{- toYaml .labels }}
{{- end }}
{{- end }}

{{- define "common.label.versioned.value" -}}
{{- $name := .name | default "" -}}
{{- if $name -}}
{{- $name = printf "-%s" $name -}}
{{- end -}}
{{- if not .labels -}}
app: {{ include "common.name.value" . }}{{ $name }}
version: {{ .version }} 
{{- else }}
{{- toYaml .labels }}
{{- end }}
{{- end }}